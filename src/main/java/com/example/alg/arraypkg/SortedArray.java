package com.example.alg.arraypkg;

public class SortedArray {
    /**
     * Given a sorted array, remove the duplicates in place such that each element appear
     * only once and return the new length.

     Do not allocate extra space for another array, you must do this in place with constant memory.

     For example,
     Given input array nums = [1,1,2],

     Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
     It doesn't matter what you leave beyond the new length.
     */
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int noDuplicate = 0;
        int position = 0;
        for(int i = 1; i<nums.length; i++){
            if(nums[i]==nums[position]){
               noDuplicate++;

            }else{
                nums[++position]=nums[i];
            }

        }
      return nums.length-noDuplicate;

    }

    /**
     * Follow up for "Remove Duplicates":
     What if duplicates are allowed at most twice?

     For example,
     Given sorted array nums = [1,1,1,2,2,3],

     Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
     It doesn't matter what you leave beyond the new length.
     */
    public int removeDuplicates2(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int extraDuplicateElement = 1;
        if(nums.length<2){
            return nums.length;
        }
        int noDuplicate = 0;
        int position = 0;
        int currentDuplicates=0;
        for(int i = 1; i<nums.length; i++){
            if(nums[i]==nums[position]){
                if(currentDuplicates<extraDuplicateElement){
                    nums[++position]=nums[i];
                    currentDuplicates++;
                }else {
                    noDuplicate++;
                }

            }else{
                nums[++position]=nums[i];
                currentDuplicates=0;
            }

        }
        return nums.length-noDuplicate;
    }



}
