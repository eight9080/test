package com.example.alg.mathpck;

public class MultiplyStrings {
    /**
     *Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

     Note:

     The length of both num1 and num2 is < 110.
     Both num1 and num2 contains only digits 0-9.
     Both num1 and num2 does not contain any leading zero.
     You must not use any built-in BigInteger library or convert the inputs to integer directly.

     */
    public String multiply(String num1, String num2) {

        int l1 = num1.length();
        int l2 = num2.length();
        int[] result = new int[l1+l2];

        for (int i = l1-1; i >=0 ; i--) {
            for (int j = l2-1; j >=0 ; j--) {
                final int i1 = num1.charAt(i) - '0';
                final int i2 = num2.charAt(j) - '0';
                int multiply = i1*i2;

                int sum = multiply + result[i+j+1];

                result[i+j] += sum/10;
                result[i+j+1]=sum % 10;
            }
        }

        final StringBuilder s = new StringBuilder();
        for (int val: result) {
            if(s.length()==0 && val==0) continue;
            s.append(val);
        }
        return s.length()==0 ? "0": s.toString();
    }
}
