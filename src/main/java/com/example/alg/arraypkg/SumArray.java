package com.example.alg.arraypkg;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class SumArray {

    /**
     * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
     * <p>
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
     * <p>
     * You may assume that each input would have exactly one solution and you may not use the same element twice.
     * <p>
     * Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
     */
    public int[] twoSum(int[] numbers, int target) {

        int[] indexes = new int[2];

        if (numbers == null || numbers.length < 2) {
            return indexes;
        }

        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int sum = numbers[start] + numbers[end];

            if (sum == target) {
                indexes[0] = start + 1;
                indexes[1] = end + 1;
                return indexes;
            }
            if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return indexes;
    }

    /**Daily 1
     * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
     * <p>
     * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
     * Another way is to use a set to remember the numbers we've seen so far. Then for a given number,
     * we can check if there is another number that, if added, would sum to k.
     * This would be O(N) since lookups of sets are O(1) each.
     */
    public boolean existsTwoSum(int[] numbers, int target) {
        Set<Integer> seen = new HashSet<>();
        return IntStream.of(numbers)
                .boxed()
                .map(value -> {
                    final int valueToBeFound = target - value;
                    if (seen.contains(valueToBeFound)) {
                        return true;
                    }
                    seen.add(value);
                    return false;
                }).filter(value -> value)
                .findFirst().orElse(false);

    }

}
