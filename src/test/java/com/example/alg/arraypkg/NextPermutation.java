package com.example.alg.arraypkg;

public class NextPermutation {

    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

     If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

     The replacement must be in-place, do not allocate extra memory.

     Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
     1,2,3 → 1,3,2
     3,2,1 → 1,2,3
     1,1,5 → 1,5,1

     */
    public void nextPermutation(int[] nums) {

        if(nums==null || nums.length<=1){
            return;
        }

        int i = nums.length-1;

        for (; i>0 ; i--) {
            if(nums[i]>nums[i-1]){
                break;
            }
        }

        if(i!=0){
            swapArray(nums, i-1);
        }

        reverseArray(nums, i);

    }

    private void reverseArray(int[] nums, int i) {
        int start = i;
        int end = nums.length-1;
        while (start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end]=temp;
            start ++;
            end --;
        }
    }

    private void swapArray(int[] nums, int i) {
        for (int j = nums.length-1; j > i ; j--) {
            if(nums[j]>nums[i]){
                int temp = nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                break;
            }
        }
    }
}
