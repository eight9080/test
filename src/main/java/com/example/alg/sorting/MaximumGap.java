package com.example.alg.sorting;

public class MaximumGap {
    /**
     * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

     Try to solve it in linear time/space.

     Return 0 if the array contains less than 2 elements.

     You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

     Analysis

     We can use a bucket-sort like algorithm to solve this problem in time of O(n) and space O(n). The basic idea is to project each element of the array to an array of buckets. Each bucket tracks the maximum and minimum elements. Finally, scanning the bucket list, we can get the maximum gap.
     */
    public int maximumGap(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }


        Bucket[] buckets = new Bucket[nums.length+1];
        for(int i=0; i<buckets.length; i++){
            buckets[i] = new Bucket();
        }

        double interval = ((double)nums.length)/(max-min);
        //distribute every number to a bucket array
        for(int i=0; i<nums.length; i++){
            final int num = nums[i];
            final int index = (int)((num - min) * interval);

            if(buckets[index].low==-1){
                buckets[index].low=num;
                buckets[index].high=num;
            }else {
                buckets[index].low=Math.min(buckets[index].low, num);
                buckets[index].high=Math.max(buckets[index].high, num);
            }
        }

        int result = 0;
        int prev = buckets[0].high;
        for(int i =0; i<buckets.length; i++){

            if(buckets[i].low!=-1){
                result = Math.max(result, buckets[i].low-prev);
                prev=buckets[i].high;
            }

        }

        return result;

    }


}


class Bucket{
    int low;
    int high;
    public Bucket(){
        low = -1;
        high = -1;
    }
}
