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

}
