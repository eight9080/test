package com.example.alg.arraypkg;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.function.ToIntBiFunction;

/**
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * This problem can be solved by using a stack. We can loop through each element in the given array.
 * When it is a number, push it to the stack.
 * When it is an operator, pop two numbers from the stack, do the calculation, and push back the result.
 */
public class PolishNotation {

    public static final String OPERATORS = "+-*/";
    private static final Map<String, ToIntBiFunction<Integer, Integer>> OPERATIONS = new HashMap<>();

    static {
        OPERATIONS.put("+", (a, b) -> a + b);
        OPERATIONS.put("-", (a, b) -> a - b);
        OPERATIONS.put("*", (a, b) -> a * b);
        OPERATIONS.put("/", (a, b) -> a / b);
    }

    public  int evalRPN(String[] tokens) {


        final Deque<String> stackCalculation = new ArrayDeque<>();

        for (String token : tokens) {
            if (!isOperator(token)) {
                stackCalculation.push(token);
            } else {
                int a = Integer.valueOf(stackCalculation.pop());
                int b = Integer.valueOf(stackCalculation.pop());
                final ToIntBiFunction<Integer, Integer> operation = OPERATIONS.get(token);
                stackCalculation.push(String.valueOf(operation.applyAsInt(b,a)));
            }
        }
        if (!stackCalculation.isEmpty()) {
            return Integer.valueOf(stackCalculation.pop());
        }
        return 0;
    }

    private  boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

}
