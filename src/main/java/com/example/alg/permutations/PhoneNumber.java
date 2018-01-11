package com.example.alg.permutations;

import com.example.alg.stringpck.IntegerToEnglish;

import java.util.*;

public class PhoneNumber {
    /**
     * Given a digit string, return all possible letter combinations that the number could represent.
     * <p>
     * A mapping of digit to letters (just like on the telephone buttons) is given below.
     * <p>
     * <p>
     * <p>
     * Input:Digit string "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     */
    public List<String> letterCombinations(String digits) {

        if(digits == null || digits.length() == 0)
            return Collections.emptyList();

        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "");


        List<String> result = new ArrayList<>();

        dfs(map, digits, 0, new StringBuilder(), result);

        return result;
    }

    private void dfs(Map<Integer, String> map, String digits, int index,
                     StringBuilder current, List<String> result) {

        if (digits.isEmpty()) {
            result.add(current.toString());
            return;
        }

        final Integer number = Character.getNumericValue(digits.charAt(0));
        final String letters = map.get(number);
        for (int indexLetter = 0; indexLetter < letters.length(); indexLetter++) {
            final char c = letters.charAt(indexLetter);
            current.append(c);
            dfs(map, digits.substring(1), index + 1, current, result);
            current.deleteCharAt(current.length() - 1);

        }

    }
}
