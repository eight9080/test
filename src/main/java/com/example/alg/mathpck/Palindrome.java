package com.example.alg.mathpck;

public class Palindrome {
    /**
     * Determine whether an integer is a palindrome. Do this without extra space.
     */
    public boolean isPalindrome(int x) {

        if(x==0){
            return true;
        }
        if(x<0){
            return false;
        }

        int y = Math.abs(x);

        int divisor = 1;
        while (x/divisor>=10){
            divisor*=10;
        }

        while (divisor>=1) {
           final int leftDigit = y/ divisor;
           final int rightDigit = y % 10;
           if(leftDigit!=rightDigit){
               return false;
           }
           y = y%divisor;
           y = y/10;
           divisor= divisor/100;

        }

        return true;
    }
}
