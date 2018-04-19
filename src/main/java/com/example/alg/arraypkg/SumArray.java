package com.example.alg.arraypkg;

public class SumArray {

    /**
     * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

     The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

     You may assume that each input would have exactly one solution and you may not use the same element twice.

     Input: numbers={2, 7, 11, 15}, target=9
     Output: index1=1, index2=2
     */
    public int[] twoSum(int[] numbers, int target) {

        int[] indexes = new int[2];

        if (numbers == null || numbers.length < 2) {
            return indexes;
        }

        int start = 0;
        int end = numbers.length-1;

        while (start<end){
            int sum = numbers[start]+numbers[end];

            if(sum==target){
                indexes[0]= start+1;
                indexes[1]= end+1;
                return indexes;
            }
            if(sum>target){
                end--;
            }else {
                start++;
            }
        }
        return indexes;
    }

}
