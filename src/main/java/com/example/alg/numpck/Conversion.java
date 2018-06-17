package com.example.alg.numpck;

public class Conversion {

    /**
     * Objective: Given a number convert it to base 3 representation.
     *
     * Example:
     *
     * N = 35
     * Base 3 representation: 1022
     *
     * N = 50
     * Base 3 representation: 1212
     * Till the number is greater than 0, keep dividing it by 3 and append remainder to the result (append it at the beginning of the result)
     *
     * N = 35, result =””
     * N = N/3 => 35/3 => 11 remainder =2 So
     * N = 11, result =”2”
     * N = N/3 => 11/3 => 3 remainder =2 So
     * N = 3, result =”22”
     * N = N/3 => 3/3 => 1 remainder =0 So
     * N = 1, result =”022”
     * N = N/3 => 1/3 => 0 remainder =1 So
     * N = 0, result =”1022”
     */
    public static String convertToBase3(int N){

        String result = "";
        while (N>0){
            int remainder = N%3;
            N = N/3;
            result = remainder+result;
        }
        return result;
    }


}
