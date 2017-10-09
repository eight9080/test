package com.example.alg.arraypkg;

import java.util.ArrayDeque;
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

        Deque<String> stack = new ArrayDeque<>();
        final char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (isDigit(aChar) || isSign(aChar) || aChar == '(') {
                stack.push(new String(new char[]{aChar}));
            }
            if (aChar == ')') {
                int partialResult = getPartialResult(stack);
                stack.push(String.valueOf(partialResult));
            }
        }

        if(!stack.isEmpty()){
            if(stack.size()==1){
                return Integer.valueOf(stack.pop());
            }else{
                return getPartialResult(stack);
            }
        }
        return 0;
    }

    private int getPartialResult(Deque<String> stack) {
        int partialResult = 0;
        Operation op = null;
        while (!stack.isEmpty()) {
            final String operator = stack.pop();
            if (operator.equals("(")) {
                break;
            }
            if (isDigit(operator)) {
                if (op == null) {
                    partialResult = Integer.valueOf(operator);
                } else {
                    partialResult = calculate(operator, partialResult, op);
                    op = null;
                }
            }
            if (isSign(operator)) {
                op = Operation.from(operator);
            }
        }
        return partialResult;
    }

    private int calculate(String operator, int partialResult, Operation op) {
        if(op==Operation.PLUS){
            return partialResult+ Integer.valueOf(operator);
        }
        if(op==Operation.MINUS){
            return   Integer.valueOf(operator)-partialResult;
        }
        return 0;
    }

    private boolean isDigit(char num){
        return num>='0' && num<='9';
    }
    private boolean isDigit(String num){
        return num.matches("[-+]?\\d*\\.?\\d+");
    }

    private boolean isSign(char num){
        return num=='+' || num=='-';
    }

    private boolean isSign(String num){
        return num.equals("+") || num.equals("-");
    }

    enum Operation{
        PLUS,
        MINUS;

        public static Operation from(String ch){
            if(ch.equals("+")) return PLUS;
            if(ch.equals("-")) return MINUS;
            return null;
        }


    }

}
