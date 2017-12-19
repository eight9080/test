package com.example.alg.dynamic;

public class LongestPalindrome {
    /**
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

     Example:

     Input: "babad"

     Output: "bab"

     Note: "aba" is also a valid answer.
     Example:

     Input: "cbbd"

     Output: "bb"
     */
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return null;
        }

        if (s.length() == 1) {
            return s;
        }
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String palindrome = getPalindrome(s, i, i);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
            // get longest palindrome with center of i, i+1
            palindrome = getPalindrome(s, i, i + 1);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
        }

        return longest;
    }

    // Given a center, either one letter or two letter,
    // Find longest palindrome
    public String getPalindrome(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }

    //TODO Manacher’s algorithm
    //http://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-4/
}
