package com.example.alg.arraypkg;

import java.util.Arrays;

public class FindingCycle {
    /**
     * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
     * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

     Note:
     You must not modify the array (assume the array is read only).
     You must use only constant, O(1) extra space.
     Your runtime complexity should be less than O(n2).
     There is only one duplicate number in the array,
     but it could be repeated more than once.

     */
    public static int findDuplicate(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int slow = 0;
        int fast = 0;

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
            System.out.println("Slow "+slow+" fast "+fast);
            System.out.println(Arrays.toString(nums));
        } while(slow != fast);
        System.out.println("--------");
        int find = 0;

        while(find != slow){
            slow = nums[slow];
            find = nums[find];
            System.out.println("Slow "+slow+" find "+find);
            System.out.println(Arrays.toString(nums));
        }
        return find;
    }
}
