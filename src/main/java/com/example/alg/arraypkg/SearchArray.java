package com.example.alg.arraypkg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchArray {

    /**
     * Given a sorted array and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * You may assume no duplicates in the array.

     Here are few examples.

     [1,3,5,6], 5 -> 2
     [1,3,5,6], 2 -> 1
     [1,3,5,6], 7 -> 4
     [1,3,5,6], 0 -> 0
     */
    public static int searchInsert(int[] nums, int target) {
        if (nums == null)
            return -1;
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        int i = 0;
        int j = nums.length;

        while (i<j){
            int m = (i+j)/2;
            if(target>nums[m]){
                i=m+1;
            }else{
                j = m;
            }

        }
        return j;
    }


    /**
     * Given an array of size n, the goal is to find out the smallest number that is
     * repeated exactly ‘k’ times where k > 0?
     And

     Examples:

     Input : a[] = {2, 1, 3, 1, 2, 2}
     k = 3
     Output : 2

     Input : a[] = {3, 4, 3, 2, 1, 5, 5}
     k = 2
     Output : 3
     Explanation: As 3 is smaller than 5.
     So 3 should be printed.
     */
    public static Integer searchSmallestNumber(int[] nums, int noOccurrences){
        final Map<Integer, Integer> mapOccurrences = Arrays.stream(nums).boxed()
                .collect(Collectors.toMap(intValue -> intValue, intValue -> 1,
                        (noOccurrence1, noOccurrence2) -> ++noOccurrence1));
        mapOccurrences.forEach((key, val) -> System.out.println("key "+key+" value "+val));

        final Optional<Integer> smallestElem = mapOccurrences.entrySet().stream()
                .filter(elem -> elem.getValue() == noOccurrences)
                .map(Map.Entry::getKey)
                .sorted()
                .findFirst();

        return smallestElem.orElse(null);
    }

    /**
     * Given a sorted array of integers, find the starting and ending position of a given target value.
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * If the target is not found in the array, return [-1, -1].
     * For example, given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
     */
    public int[] searchRange(int[] nums, int target) {
        final int[] positions = new int[]{-1,-1};
        if(nums == null || nums.length == 0){
            return positions;
        }

        int low = 0;
        int high = nums.length - 1;

        while (high >= low) {
            int mid = (low+high) / 2;
            final int middleNum = nums[mid];
            if (middleNum == target) {
                int j = mid;
                while (j-1 >= 0 && nums[j-1] == target) {
                    j--;
                }
                int k = mid;
                while (k+1 < nums.length && nums[k+1] == target) {
                        k++;
                }
                positions[0] = j;
                positions[1] = k;
                break;
            }else if(middleNum<target){
                low = mid+1;
            }else if(middleNum>target){
                high = mid-1;
            }
        }
        return positions;
    }

}
