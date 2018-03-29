package com.example.alg.arraypkg;


import java.util.*;

public class Intersection {

    /**
     * Sort both arrays, use two pointers
     * Time complexity: O(nlogn)
     */
    public Integer[] intersectionTwoPointers(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> result = new HashSet<>();
        int indexNum1 = 0;
        int indexNum2 = 0;

        while(indexNum1 < nums1.length && indexNum2<nums2.length){
            if(nums1[indexNum1]==nums2[indexNum2]){
                result.add(nums1[indexNum1]);
                indexNum1++;
                indexNum2++;
            }else if(nums1[indexNum1]<nums2[indexNum2]){
                indexNum1++;
            }else{
                indexNum2++;
            }
        }
        return result.toArray(new Integer[result.size()]);
    }

    /**
     * Binary search

     Time complexity: O(nlogn)

     */
    public Integer[] intersectionBinarySearch(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        Set<Integer> result = new HashSet<>();
        for(int elem: nums1){
            if(Arrays.binarySearch(nums2, elem)>-1){
                result.add(elem);
            }
        }
        return result.toArray(new Integer[result.size()]);
    }

    /**
     * Given two arrays, write a function to compute their intersection.

     Example:
     Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
     *
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();
        int indexNum1 = 0;
        int indexNum2 = 0;

        while(indexNum1 < nums1.length && indexNum2<nums2.length){
            if(nums1[indexNum1]==nums2[indexNum2]){
                result.add(nums1[indexNum1]);
                indexNum1++;
                indexNum2++;
            }else if(nums1[indexNum1]<nums2[indexNum2]){
                indexNum1++;
            }else{
                indexNum2++;
            }
        }
        return result.stream().mapToInt(i->(int)i).toArray();
    }
}
