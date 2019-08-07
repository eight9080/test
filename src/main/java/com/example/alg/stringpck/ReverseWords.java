package com.example.alg.stringpck;

import java.util.Arrays;

/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * <p>
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 * <p>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 */
public class ReverseWords {

    /**
     * Write a function that takes a string as input and returns the string reversed.
     * <p>
     * Example:
     * Given s = "hello", return "olleh".
     */
    public String reverseStringSimple(String s) {
        final char[] chars = s.toCharArray();
        reverse(chars, 0, s.length() - 1);
        return new String(chars);
    }

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

    /**
     * 557. Reverse Words in a String III
     * Given a string, you need to reverse the order of characters in each word within
     * a sentence while still preserving whitespace and initial word order.
     *
     */
    public String reverseWords(String s) {
        final char[] chars = s.toCharArray();
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' '){
                reverse(chars, start, i-1);
                start=i+1;
            }
        }
        if(start<chars.length) {
            reverse(chars, start, chars.length-1);
        }
        return  new String(chars);
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
        final String[] strings = input.split("\\s+");
        return Arrays.stream(strings).map(String::trim).reduce("", (a, b) -> b + " " + a).trim();
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


    /**
     * 541. Reverse String II
     * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
     * Example:
     * Input: s = "abcdefg", k = 2
     * Output: "bacdfeg"
     */
    public String reverseStr(String s, int k) {


        final char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i += 2 * k) {

            int posStart = i;
            int posEnd = Math.min(posStart + k, chars.length) -1;

            while (posStart < posEnd) {
                swap(chars, posStart, posEnd);
                posStart++;
                posEnd--;
            }

        }

        return new String(chars);
    }

}