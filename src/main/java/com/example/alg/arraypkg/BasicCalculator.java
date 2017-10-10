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


    /**
     * Implement a basic calculator to evaluate a simple expression string.

     The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

     You may assume that the given expression is always valid.

     Some examples:
     "3+2*2" = 7
     */
    public int calculate2(String s) {
        // delete white spaces
        s = s.replaceAll(" ", "");

        int len = s.length();

        int pm = 1; // 1 plus -1 minus
        int md = -1; // 0 m 1 d
        int result = 0;
        int previousResult = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int sum = s.charAt(i) - '0';
                while (i< len-1 && Character.isDigit(s.charAt(i+1))){
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                if(md==1){
                    if(sum!=0) {
                        previousResult = previousResult / sum;
                    }else{
                        previousResult = 0;
                    }
                    md=-1;
                }else if(md==0){
                    previousResult = previousResult* sum;
                    md=-1;
                }else {
                    previousResult = sum;
                }
            }else if(s.charAt(i)=='+'){
                result = result + previousResult * pm;
                pm =1;
            }else if(s.charAt(i)=='-'){
                result = result + previousResult * pm;
                pm =-1;
            }else if(s.charAt(i)=='*'){
                md = 0;
            }else if(s.charAt(i)=='/'){
                md = 1;
            }

        }

        result = result + previousResult * pm;

        return result;
    }

}
