package com.example.alg.mathpck;

public class Power {
    /**
     * Implement pow(x, n).
     * Example 1:

     Input: 2.00000, 10
     Output: 1024.00000
     Example 2:

     Input: 2.10000, 3
     Output: 9.26100
     */
    public double myPow(double x, int n) {

        if (n == 0)
            return 1;
        if(n==1){
            return x;
        }

        if(n == Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        }

        if(n<0){
            return 1/ myPow(x, -n);
        }

        final double v = myPow(x, n / 2);

        if(n%2==0){
            return v*v;
        }else {
            return v*v*x;
        }

    }

    /**
     * Given an integer, write a function to determine if it is a power of two.
     */
    public boolean isPowerOfTwo(int n) {
return true;
    }
}
