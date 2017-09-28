package com.example.alg.arraypkg;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection {

    /**
     * Sort both arrays, use two pointers
     * Time complexity: O(nlogn)
     */
    public Integer[] intersection(int[] nums1, int[] nums2) {
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
        Integer [] temp = new Integer[result.size()];
        return result.toArray(new Integer[result.size()]);
    }
}
