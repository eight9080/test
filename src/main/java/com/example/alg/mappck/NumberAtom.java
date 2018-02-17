package com.example.alg.mappck;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;

public class NumberAtom {

    /**
     * Given a chemical formula (given as a string), return the count of each atom.
     * <p>
     * An atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.
     * <p>
     * 1 or more digits representing the count of that element may follow if the count is greater than 1. If the count is 1, no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.
     * <p>
     * Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a formula.
     * <p>
     * A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.
     * <p>
     * Given a formula, output the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.
     * <p>
     * Example 1:
     * Input:
     * formula = "H2O"
     * Output: "H2O"
     * Explanation:
     * The count of elements are {'H': 2, 'O': 1}.
     * Example 2:
     * Input:
     * formula = "Mg(OH)2"
     * Output: "H2MgO2"
     * Explanation:
     * The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
     * Example 3:
     * Input:
     * formula = "K4(ON(SO3)2)2"
     * Output: "K4N2O14S4"
     * Explanation:
     * The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
     */
    public String countOfAtoms(String formula) {

        final TreeMap<String, Integer> numberAtoms = new TreeMap<>();

        helper(numberAtoms, formula, 0);
        final StringBuilder s = new StringBuilder();
        numberAtoms.forEach((k, v) -> {
            s.append(k).append(v == 1 ? "" : v);
        });
        return s.toString();
    }

    private int helper(Map<String, Integer> currentAtoms,
                       String formula, int start) {

        Map<Character, Character> special = new HashMap<>();
        special.put('(', ')');


        for (int i = start; i < formula.length(); i++) {

            final char c = formula.charAt(i);

            if (Character.isLetter(c)) {
                int startAtom = i;
                i = getEndIndex(formula, i, Character::isLowerCase);
                final String atom = formula.substring(startAtom, i + 1);
                int numberAtomCurrent = 1;

                if (i + 1 < formula.length()) {
                    final char cNumber = formula.charAt(i + 1);
                    if (Character.isDigit(cNumber)) {
                        int startNumber = i + 1;
                        i = getEndIndex(formula, i, Character::isDigit);
                        numberAtomCurrent = Integer.valueOf(formula.substring(startNumber, i + 1));
                    }
                }
                final int numberToAdd = numberAtomCurrent;
                currentAtoms.compute(atom, (k, v) -> v == null ? numberToAdd : v + numberToAdd);
            }

            if (special.containsKey(c)) {
                Map<String, Integer> nextAtoms = new HashMap<>();
                i = helper(nextAtoms, formula, i + 1);
                nextAtoms.forEach((k, v2) -> currentAtoms.merge(k, v2, (a, b) -> a + b));
                continue;
            }

            if (special.containsValue(c)) {
                if (i + 1 < formula.length()) {
                    final char cNext = formula.charAt(i + 1);
                    if (!Character.isDigit(cNext)) {
                        return i;
                    } else {
                        int startNumber = i + 1;
                        i = getEndIndex(formula, i, Character::isDigit);
                        final Integer numberAtoms = Integer.valueOf(formula.substring(startNumber, i + 1));
                        currentAtoms.replaceAll((k, v) -> v * numberAtoms);
                        return i;
                    }
                }
            }

        }


        return formula.length() - 1;
    }

    private int getEndIndex(String formula, int i, Predicate<Character> test) {
        while (i + 1 < formula.length() && test.test(formula.charAt(i + 1))) {
            i++;
        }
        return i;
    }
}
