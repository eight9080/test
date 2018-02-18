package com.example.alg.mathpck;

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
}
