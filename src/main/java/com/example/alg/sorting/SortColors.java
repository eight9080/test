package com.example.alg.sorting;

public class SortColors {
    /**
     * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

     Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

     Note:
     You are not suppose to use the library's sort function for this problem.

     click to show follow up.

     Follow up:
     A rather straight forward solution is a two-pass algorithm using counting sort.
     First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

     Could you come up with an one-pass algorithm using only constant space?
     */
    public void sortColors(int[] nums) {

        if(nums==null||nums.length<2){
            return;
        }

        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }

        for(int i = 1; i<=2; i++){
            count[i]=count[i-1]+count[i];
        }

        int[] sorted = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = count[nums[i]]-1;
            count[nums[i]]=index;
            sorted[index]=nums[i];

        }

        System.arraycopy(sorted,0,nums, 0, nums.length);
    }

    /**
     * In solution 1, two arrays are created. One is for counting, and the other is for storing the sorted array (space is O(n)). We can improve the solution so that it only uses constant space. Since we already get the count of each element,
     * we can directly project them to the original array, instead of creating a new one.
     */
    public void sortColors2(int[] nums) {

        if(nums==null||nums.length<2){
            return;
        }

        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }

        int index=0;
        int indexCount=0;

        while (indexCount<=2){

            if(count[indexCount]>0){
                nums[index++]=indexCount;
                count[indexCount]--;
            }else {
                indexCount++;
            }

        }
    }
}
