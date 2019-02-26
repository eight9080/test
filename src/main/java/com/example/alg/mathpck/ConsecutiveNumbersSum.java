package com.example.alg.mathpck;

import java.util.ArrayDeque;

/**
 * 829
 * Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?
 *
 * Example 1:
 *
 * Input: 5
 * Output: 2
 * Explanation: 5 = 5 = 2 + 3
 * Example 2:
 *
 * Input: 9
 * Output: 3
 * Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
 * Example 3:
 *
 * Input: 15
 * Output: 4
 * Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 */
public class ConsecutiveNumbersSum {

    public int consecutiveNumbersSum(int N) {

        int count = 0;
        for (int i = 1; i <= (int)Math.sqrt(2*N); i++) {
            if ((2*N-i*(i-1)) % (2*i) == 0) count++;
        }
        return count;

    }
}
