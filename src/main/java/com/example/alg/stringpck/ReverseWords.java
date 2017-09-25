package com.example.alg.stringpck;

import java.util.Arrays;

/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

 The input string does not contain leading or trailing spaces and the words are always separated by a single space.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".
 */
public class ReverseWords {

    public static String reverseString(String input) {
        final char[] chars = input.toCharArray();
        reverseWords(chars);
        return new String(chars);
    }


    private static void reverseWords(char[] s) {
        int i = 0;
        for (int j = 0; j < s.length; j++) {
            if (s[j] == ' ') {
                reverse(s, i, j - 1);
                i = j + 1;
            }
        }

        reverse(s, i, s.length - 1);

        reverse(s, 0, s.length - 1);

    }

    private static void reverse(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static String reverseStringJava8(String input) {
        final String[] strings = input.split(" ");
        return Arrays.stream(strings).reduce("", (a, b) -> b + " " + a).trim();
    }

    /**
     * Reverse an array without affecting special characters
     * Given a string, that contains special character together with alphabets (‘a’ to ‘z’ and ‘A’ to ‘Z’),
     * reverse the string in a way that special characters are not affected.
     * <p>
     * Examples:
     * <p>
     * Input:   str = "a,b$c"
     * Output:  str = "c,b$a"
     * Note that $ and , are not moved anywhere.
     * Only subsequence "abc" is reversed
     * <p>
     * Input:   str = "Ab,c,de!$"
     * Output:  str = "ed,c,bA!$"
     *
     * @param item
     */
    public static String reverseStringWithSpecialCharacters(String item) {
        final char[] chars = item.toCharArray();
        int left = 0;
        int right = item.length() - 1;

        while (left < right) {
            if (!Character.isLetterOrDigit(chars[left])) {
                left++;
            } else {
                if (!Character.isLetterOrDigit(chars[right])) {
                    right--;
                } else {
                        swap(chars, left, right);
                        left++;
                        right--;
                }
            }
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int left, int right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }
}