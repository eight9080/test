package com.example.alg.stringpck;

public class Conversion {
    /**
     * Implement atoi to convert a string to an integer.
     * <p>
     * 1. null or empty string
     * 2. white spaces
     * 3. +/- sign
     * 4. calculate real value
     * 5. handle min & max
     */
    public static int atoi(String str) {
        if (str == null || str.length() < 1)
            return 0;

        // trim white spaces
        str = str.trim();

        char flag = '+';

        //check negative to store result
        int i = 0;
        if(str.charAt(0)=='-'){
            flag='-';
            i++;
        }else if(str.charAt(0)=='+'){
            i++;
        }

        double result = 0;
        while (str.length()>i && str.charAt(i)>='0' && str.charAt(i)<='9'){
            result  = result * 10 + (str.charAt(i)-'0');
            i++;
        }

        if(flag=='-'){
            result = -result;
        }
        if(result>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(result<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int) result;

    }
}
