package com.example.alg.stringpck;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class ValidParentheses {

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
     * determine if the input string is valid.

     The brackets must close in the correct order, "()" and "()[]{}"
     are all valid but "(]" and "([)]" are not.
     */
    public static boolean checkParentheses(String s){

        final HashMap<Character, Character> specialCharacters = new HashMap<>();
        specialCharacters.put('(', ')');
        specialCharacters.put('[', ']');
        specialCharacters.put('{', '}');

        Deque<Character> stackCharacters = new ArrayDeque<>();

        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            final char aChar = chars[i];
            if(specialCharacters.containsKey(aChar)){
                stackCharacters.push(aChar);
            }else if(specialCharacters.containsValue(aChar)){
                if(!stackCharacters.isEmpty() && specialCharacters.get(stackCharacters.peek())==aChar){
                    stackCharacters.poll();
                }else {
                    return false;
                }
            }
        }
        return stackCharacters.isEmpty();
    }


    /**
     * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

     For "(()", the longest valid parentheses substring is "()", which has length = 2.

     Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.


     */
    public int longestValidParentheses(String s) {

        if(s==null || s.length()==0){
            return 0;
        }

        int max = 0;
        int invalidPosition = -1;
        Deque<Integer> stackPositions = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if(c=='('){
                stackPositions.push(i);
                continue;
            }

            if(stackPositions.isEmpty()){
                invalidPosition=i;
            }else {
                stackPositions.pop();
                int start;
                if(stackPositions.isEmpty()){
                    start=invalidPosition;
                }else {
                    start = stackPositions.peek();
                }
                final int distance = i - start;
                max = Math.max(max, distance);
            }
        }

        return max;

    }

}
