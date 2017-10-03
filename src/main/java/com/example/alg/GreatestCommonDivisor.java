package com.example.alg;

public class GreatestCommonDivisor {

    public static int gcdRec(int a, int b){
        if(a%b==0){
            return b;
        }
        return gcdRec(b, a % b);
    }

    public static int gcdIterativ(int a, int b){
        int remainder;
        while (b!=0){
            remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
}
