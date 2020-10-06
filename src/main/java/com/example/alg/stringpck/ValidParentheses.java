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

    /**
     * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
     *
     * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
     * Any right parenthesis ')' must have a corresponding left parenthesis '('.
     * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
     * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
     * An empty string is also valid.
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {
        int lo= 0;
        int hi = 0;
        for(char c: s.toCharArray()){
            lo += c=='(' ? 1 : -1;
            hi += c!=')' ? 1 : -1;
            if(hi<0) break;
            lo = Math.max(lo,0);
        }
        return lo==0;
    }

}
