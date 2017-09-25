package com.example.alg.arraypkg;

public class RotateArray {
    /**
     * Rotate an array of n elements to the right by k steps.

     For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]
     Space is O(n) and time is O(n).
     * @param nums array
     * @param k no steps
     * @return
     */
    public static void rotate(int[] nums, int k){
        int noSteps = k;
        if(noSteps> nums.length){
            noSteps = noSteps%nums.length;
        }

        final int[] result = new int[nums.length];
        for (int i = 0; i < noSteps; i++) {
            result[i] = nums[nums.length-noSteps+i];
        }
        int j= 0;
        for (int i = noSteps; i < nums.length; i++) {
            result[i] = nums[j];
            j++;
        }

        System.arraycopy(result, 0, nums, 0, nums.length);
    }

    /**
     * O(1) space
     * O(n*k) time
     * @param nums
     * @param noSteps
     */
    public static void bubbleRotate(int [] nums, int noSteps){
        for (int i = 0; i < noSteps; i++) {
            for (int j = nums.length-1; j >0 ; j--) {
                swap(nums, j, j-1);
            }
        }
    }

    /**
     * rotates array  O(1) space and in O(n) time
     1. Divide the array two parts: 1,2,3,4 and 5, 6
     2. Reverse first part: 4,3,2,1,5,6
     3. Reverse second part: 4,3,2,1,6,5
     4. Reverse the whole array: 5,6,1,2,3,4
     * @param nums array to rotate
     * @param k noSteps
     */
    public static void reverseRotate(int [] nums, int k){
        int noSteps = k;
        if(noSteps> nums.length){
            noSteps = noSteps%nums.length;
        }

        int lengthFirstPart = nums.length-noSteps;
        reverseArray(nums, 0, lengthFirstPart-1);
        reverseArray(nums, lengthFirstPart, nums.length-1);
        reverseArray(nums, 0, nums.length-1);

    }

    private static void reverseArray(int[] array, int left, int right) {
        if(array==null || array.length==1){
            return;
        }

        while (left<right){
            swap(array, left, right);
            left++;
            right--;
        }
    }


    private static void swap(int[] nums, int position1, int position2) {
        int temp = nums[position1];
        nums[position1] = nums[position2];
        nums[position2] = temp;
    }

}
