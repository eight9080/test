package com.example.alg.arraypkg;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class BasicCalculator {
    /**
     * Implement a basic calculator to evaluate a simple expression string.

     The expression string may contain open ( and closing parentheses ), the plus + or minus sign -,
     non-negative integers and empty spaces.You may assume that the given expression is always valid.

     Some examples: "1 + 1" = 2, "(1)" = 1, "(1-(4-5))" = 2
     This problem can be solved by using a stack. We keep pushing element to the stack, when ')" is met,
     calculate the expression up to the first "(".
     */
    public int calculate(String s) {

        // delete white spaces
        s = s.replaceAll(" ", "");

        int len = s.length();
        int sign = 1;
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();

        final char[] chars = s.toCharArray();

        for (int i = 0; i< chars.length; i++) {
            char aChar = chars[i];
            if(Character.isDigit(aChar)){
                int sum = s.charAt(i) - '0';
                while (i< len-1 && Character.isDigit(s.charAt(i+1))){
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += sum * sign;
            }else if(s.charAt(i)=='+'){
                sign =1;
            }else if(s.charAt(i)=='-'){
                sign =-1;
            }else if(s.charAt(i)=='('){
                stack.push(result);
                stack.push(sign);
                result=0;
                sign=1;
            }else if(s.charAt(i)==')'){
                result = result * stack.pop() + stack.pop();
            }


        }
        return result;
    }



}
