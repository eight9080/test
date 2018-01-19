package com.example.alg.mathpck;

public class PlusOne {
    /**
     * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

     You may assume the integer do not contain any leading zero, except the number 0 itself.

     The digits are stored such that the most significant digit is at the head of the list.
     */
    public int[] plusOne(int[] digits) {
        if(digits==null||digits.length==0)
            return new int[0];

        int carry = 1;

        int[] tempResult = new int[digits.length];
        System.arraycopy(digits, 0, tempResult, 0, digits.length);
        for (int i = tempResult.length-1; i >=0 ; i--) {
            final int sum = tempResult[i] + carry;
            carry = (sum>=10)? 1: 0;
            tempResult[i]= sum%10;
        }
        if(carry==0){
            return tempResult;
        }
        int[] result = new int[digits.length+1];
        System.arraycopy(tempResult, 0, result, 1, tempResult.length);
        result[0]=1;
        return result;
    }
}
