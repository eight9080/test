package com.example.alg.dynamic;

import java.util.HashSet;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * <p>
 * Below is one possible representation of s1 = "great":
 * <p>
 * great
 * /    \
 * gr    eat
 * / \    /  \
 * g   r  e   at
 * / \
 * a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * <p>
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * <p>
 * rgeat
 * /    \
 * rg    eat
 * / \    /  \
 * r   g  e   at
 * / \
 * a   t
 * We say that "rgeat" is a scrambled string of "great".
 * <p>
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * <p>
 * rgtae
 * /    \
 * rg    tae
 * / \    /  \
 * r   g  ta  e
 * / \
 * t   a
 * We say that "rgtae" is a scrambled string of "great".
 * <p>
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */
public class ScrambleString {

    private enum ScrambleType {
        SAME, REVERSE, NONE;
    }

    public boolean isScramble(String s1, String s2) {

        String input = s1;
        String target = s2;

        final int mid = s1.length() / 2;

        if (mid < 2) {
            final ScrambleType scrambleType1 = checkScramble(input, target);
            return scrambleType1 != ScrambleType.NONE;
        }

        final ScrambleType scrambleType1 = checkScramble(input.substring(0, mid), target.substring(0, mid));

        final ScrambleType scrambleType2 = checkScramble(input.substring(mid, s1.length()),
                target.substring(mid, s1.length()));

        if (scrambleType1 == scrambleType2) {
            return scrambleType1 != ScrambleType.NONE;
        }
        if (scrambleType1 == ScrambleType.REVERSE || scrambleType2 == ScrambleType.REVERSE) {
            return true;
        }
        return false;
    }

    private ScrambleType checkScramble(String init, String target) {

        boolean same = true;
        boolean reverse = true;

        for (int i = 0; i < init.length(); i++) {
            final char firstCharInit = init.charAt(i);
            final char firstTarget = target.charAt(i);
            if (same && firstCharInit != firstTarget) {
                same = false;
            }
            final char lastTarget = target.charAt(init.length() - 1 - i);
            if (reverse && lastTarget != firstCharInit) {
                reverse = false;
            }

        }
        if (same) {
            return ScrambleType.SAME;
        }
        if (reverse) {
            return ScrambleType.REVERSE;
        }
        return ScrambleType.NONE;
    }

    public boolean isScramble2(String s1, String s2) {

        String input = s1;
        String target = s2;


        if (input.equals(target)) {
            return true;
        }

        int[] letters = new int[26];
        for (int i = 0; i < input.length(); i++) {
            letters[input.charAt(i) - 'a']++;
            letters[target.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }

        for (int i = 1; i < input.length(); i++) {
            if (isScramble(input.substring(0, i), target.substring(0, i))
                    && isScramble(input.substring(i), target.substring(i))) {
                return true;
            }
            if (isScramble(input.substring(0, i), target.substring(s2.length() - i))
                    && isScramble(input.substring(i), target.substring(0, s2.length() - i))) {
                return true;
            }
        }
        return false;
    }

}
