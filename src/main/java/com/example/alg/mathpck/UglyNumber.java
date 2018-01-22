package com.example.alg.mathpck;

import java.util.*;

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

    /**
     * Write a program to find the nth super ugly number.

     Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
     For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is
     the sequence of the first 12 super ugly numbers given
     primes = [2, 7, 13, 19] of size 4.

     Note:
     (1) 1 is a super ugly number for any given primes.
     (2) The given numbers in primes are in ascending order.
     (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
     (4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n<=0){
            return 0;
        }

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);

        int[] indexes = new int[primes.length];

        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min=Math.min(min, numbers.get(indexes[j])*primes[j]);
            }
            numbers.add(min);

            for (int j = 0; j < primes.length; j++) {
                if(min == numbers.get(indexes[j])*primes[j]){
                    indexes[j]++;
                }
            }

        }
        return numbers.get(n-1);

    }
}
