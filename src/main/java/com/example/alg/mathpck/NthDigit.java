package com.example.alg.mathpck;

public class NthDigit {
    /**
     * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

     Example 1:

     Input:
     3

     Output:
     3
     Example 2:

     Input:
     11

     Output:
     0

     Explanation:
     The 11th digit of the sequence
     1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
     */
    public int findNthDigit(int n) {
        if(n<10){
            return n;
        }
        
        int number = n;

        long len = 1;
        long count = 9;
        long startNumber = 1;
        
        while (number>len*count){
            number-=len*count;
            len++;
            count*=10;
            startNumber*=10;
        }

        startNumber += (number - 1) / len;

        final int digit =(int) ((number - 1) % len);

        final char c = Long.toString(startNumber).charAt(digit);
        return Character.getNumericValue(c);


    }
}
