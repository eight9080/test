package com.example.alg.mathpck;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    /**
     * Write an algorithm to determine if a number is "happy".
     * <p>
     * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
     * <p>
     * Example: 19 is a happy number
     * <p>
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     */
    public boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();

        int sum = n;

        while (!set.contains(sum)) {
            set.add(sum);

            sum = getSum(sum);
            if (sum == 1) {
                return true;
            }

        }
        return false;
    }

    private int getSum(int n) {
        int sum = 0;
        int num = n;
        while (num > 0) {
            final int digit = num % 10;
            sum += digit * digit;
            num = num / 10;
        }
        return sum;
    }
}
