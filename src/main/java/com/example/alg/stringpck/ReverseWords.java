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

    public static String reverseString(String input){
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

    private static void reverse(char[] s, int i, int j){
        while(i<j){
            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }

    public static String reverseStringJava8(String input){
        final String[] strings = input.split(" ");
        return Arrays.stream(strings).reduce("", (a, b) -> b + " " + a).trim();
    }
}