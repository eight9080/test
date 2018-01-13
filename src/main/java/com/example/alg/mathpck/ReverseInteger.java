package com.example.alg.mathpck;

public class ReverseInteger {

    /**
     * Given a 32-bit signed integer, reverse digits of an integer.

     Example 1:

     Input: 123
     Output:  321
     Example 2:

     Input: -123
     Output: -321
     Example 3:

     Input: 120
     Output: 21
     */
    public int reverse(int x) {
        if(x==0){
            return 0;
        }

        boolean negative = (x < 0);

        int y = negative? x *-1: x;
        long newNumber = 0;
        while (y!=0){
            final int temp = y % 10;
            newNumber = newNumber*10 +temp;
            y = y/10;
        }
        if(negative){
            newNumber= newNumber*-1;
        }
        if(newNumber>Integer.MAX_VALUE || newNumber<Integer.MIN_VALUE){
            return 0;
        }
        return (int)newNumber;
    }


}
