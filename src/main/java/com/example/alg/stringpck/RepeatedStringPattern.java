package com.example.alg.stringpck;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 Example 1:
 Input: "abab"

 Output: True

 Explanation: It's the substring "ab" twice.
 Example 2:
 Input: "aba"

 Output: False
 Example 3:
 Input: "abcabcabcabc"

 Output: True

 Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedStringPattern {
    public boolean repeatedSubstringPattern(String s) {
        StringBuilder temp = new StringBuilder();
        final int len = s.length();
        for (int i = 0; i < len; i++) {
            final char c = s.charAt(i);
            temp.append(c);
            if(len%temp.length()==0) {
                final int multiply = len / temp.length();
                if(multiply==1){
                    continue;
                }
                final StringBuilder aux = new StringBuilder();
                for (int j = 0; j < multiply; j++) {
                    aux.append(temp);
                }
                if(aux.toString().equals(s)){
                    return true;
                }
            }
        }
        return false;
    }
}
