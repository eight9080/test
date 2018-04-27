package com.example.alg.mathpck;

import java.util.ArrayList;
import java.util.List;

public class DivideIntegers {
    /**
     * Divide two integers without using multiplication, division and mod operator.

     If it is overflow, return MAX_INT.
     */
    public int divide(int dividend, int divisor) {

        if(divisor==0){
            return Integer.MAX_VALUE;
        }

        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }

        final long lDividend = Math.abs((long)dividend);
        final long lDivisor = Math.abs((long)divisor);

        if(dividend==0 || lDividend<lDivisor){
            return 0;
        }

        final long result = divide(lDividend, lDivisor);

        if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE){
            return sign==-1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return (int) (result * sign);

    }

    private long divide(long dividend, long divisor) {

        if(dividend<divisor){
            return 0;
        }
        long multiplier = 1;
        long sum = divisor;

        while (sum+sum<=dividend){
            sum+=sum;
            multiplier+=multiplier;
        }

        final long partialResult = divide(dividend - sum, divisor);

        return multiplier+ partialResult;


    }

    /**
     * A self-dividing number is a number that is divisible by every digit it contains.

     For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

     Also, a self-dividing number is not allowed to contain the digit zero.

     Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

     Example 1:
     Input:
     left = 1, right = 22
     Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if(isSelfDivide(i)){
                result.add(i);
            }

        }
        return result;
    }

    private boolean isSelfDivide(int num) {
        int currentNum = num;
        while (currentNum!=0){
            int digit = currentNum % 10;
            if(digit==0 || (num % digit!=0)){
                return false;
            }
            currentNum = currentNum/10;
        }

        return true;
    }
}
