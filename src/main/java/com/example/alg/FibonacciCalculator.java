package com.example.alg;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Java program to calculate and print Fibonacci number using both recursion
 * and Iteration.
 * Fibonacci number is sum of previous two Fibonacci numbers fn= fn-1+ fn-2
 * first 10 Fibonacci numbers are 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
 */

public class FibonacciCalculator {

    public static List<Integer> fibonacciRecList(int number) {
        return IntStream.rangeClosed(1, number)
                .map(nr -> fibonacciRec(nr))
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> fibonacciIterativeList(int number) {
        return IntStream.rangeClosed(1, number)
                .map(nr -> fibonacciIerative(nr))
                .boxed()
                .collect(Collectors.toList());
    }


    private static int fibonacciRec(int number) {
        if (number == 1 || number == 2) {
            return 1;
        }
        return fibonacciRec(number - 1) + fibonacciRec(number - 2);
    }

    private static int fibonacciIerative(int number) {
        if (number == 1 || number == 2) {
            return 1;
        }
        Integer firstNumber = 1, secondNumber = 1, fibonacciResult = 1;

        for (int i = 3; i <= number; i++) {
            fibonacciResult = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = fibonacciResult;
        }
        return fibonacciResult;

    }


}
