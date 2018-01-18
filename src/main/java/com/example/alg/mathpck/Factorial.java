package com.example.alg.mathpck;

public class Factorial {
    /**
     * Given an integer n, return the number of trailing zeroes in n!.

     Note: Your solution should be in logarithmic time complexity.
     */
    public int trailingZeroes(int n) {

        if(n<0){
            return -1;
        }

        int result = 0;
        int num = n;

        while (num>0){
            num/=5;
            result+=num;
        }
        return result;
    }
}
