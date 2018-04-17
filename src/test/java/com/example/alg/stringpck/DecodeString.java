package com.example.alg.stringpck;

import com.example.designpatterns.interpreter.breads.WheatBread;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    /**
     * Given an encoded string, return it's decoded string.

     The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

     You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

     Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

     Examples:

     s = "3[a]2[bc]", return "aaabcbc".
     s = "3[a2[c]]", return "accaccacc".
     s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
     */
    public String decodeString(String s) {

        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<String> resStack = new ArrayDeque<>();

        StringBuilder current = new StringBuilder();

        int i = 0;
        while (i<s.length()){
            final char c = s.charAt(i);

            if(Character.isDigit(c)){
                int multiplier = 0;
                while (Character.isDigit(s.charAt(i))) {
                    multiplier = multiplier * 10 + Character.getNumericValue(s.charAt(i));
                    i++;
                }
                countStack.push(multiplier);
                continue;
            }
            if(c=='['){
                resStack.push(current.toString());
                current=new StringBuilder();
                i++;
                continue;
            }
            if(Character.isLetter(c)){
                current.append(c);
                i++;
                continue;
            }
            if(c==']'){
                final StringBuilder text = new StringBuilder(resStack.pop());
                final Integer multiplier = countStack.pop();
                for (int j = 0; j < multiplier; j++) {
                    text.append(current);
                }
                current=text;
                i++;
            }
        }
        return current.toString();
    }
}
