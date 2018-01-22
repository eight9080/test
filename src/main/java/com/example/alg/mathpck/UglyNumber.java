package com.example.alg.mathpck;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber {
    /**
     * Write a program to check whether a given number is an ugly number.

     Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

     Note that 1 is typically treated as an ugly number.
     */
    public boolean isUgly(int num) {
        if(num==0) return false;
        if(num==1) return true;

        if(num%2==0){
            num=num/2;
            return isUgly(num);
        }
        if(num%3==0){
            num=num/3;
            return isUgly(num);
        }
        if(num%5==0){
            num=num/5;
            return isUgly(num);
        }
        return false;
    }

    /**
     * Write a program to find the n-th ugly number.

     Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

     Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
     */
    public int nthUglyNumber(int n) {

        if(n<=0){
            return 0;
        }

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);

        int index2 =0;
        int index3 =0;
        int index5 =0;

        while (numbers.size()<n){
            int num2=numbers.get(index2)*2;
            int num3=numbers.get(index3)*3;
            int num5=numbers.get(index5)*5;

            final int min = Math.min(num2, Math.min(num3, num5));
            numbers.add(min);

            if(min==num2){
                index2++;
            }
            if(min==num3){
                index3++;
            }
            if(min==num5){
                index5++;
            }
        }

        return numbers.get(n-1);

    }
}
