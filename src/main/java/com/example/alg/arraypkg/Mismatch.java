package com.example.alg.arraypkg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Mismatch {

    /**
     * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

     Given an array nums representing the data status of this set after the error.
     Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

     Example 1:
     Input: nums = [1,2,2,4]
     Output: [2,3]
     */
    public int[] findErrorNums(int[] nums) {

        if(nums==null || nums.length==0){
            return new int[0];
        }

        final Map<Integer, Integer> numsMap = IntStream.rangeClosed(1, nums.length)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), v -> 0));

        Arrays.stream(nums).forEach(num -> numsMap.put(num, numsMap.get(num)+1));

        final int[] integers = numsMap.entrySet().stream()
                .filter(v -> v.getValue() != 1)
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .map(Map.Entry::getKey)
                .mapToInt(a->a)
                .toArray();


        return integers;
    }


}
