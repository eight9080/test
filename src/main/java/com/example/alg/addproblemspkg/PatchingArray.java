package com.example.alg.addproblemspkg;

public class PatchingArray {

    /**
     * Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.

     Example 1:
     nums = [1, 3], n = 6
     Return 1.

     Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
     Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
     Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
     So we only need 1 patch.

     Example 2:
     nums = [1, 5, 10], n = 20
     Return 2.
     The two patches can be [2, 4].

     Example 3:
     nums = [1, 2, 2], n = 5
     Return 0.

     Let miss be the smallest number that can not be formed by the sum of elements in the array.
     All elements in [0, miss) can be formed. The miss value starts with 1.
     If the next number nums[i]<=miss, then the boundary is increased to be [0, miss+nums[i]),
     because all numbers between the boundaries can be formed;
     if next number nums[i]>miss, that means there is a gap and we need to insert a number,
     inserting miss itself is a the choice because its boundary doubles
     and cover every number between the boundaries [0, miss+miss).

     Here is an example.
     Given nums=[1, 4, 10] and n=50.

     miss=1;
     i=0, nums[i]<=miss, then miss=1+1=2
     i=1, nums[i]>2, then miss = miss+miss = 4
     i=1, nums[i]<=miss, then miss = miss+num[i] = 8
     i=2, nums[i]>miss, then miss = miss+miss = 16
     i=2, nums[i]>miss, then miss = miss+miss = 32
     i=2, nums[i]>miss, then miss = miss+miss = 64
     64 > 50. Done! 4 elements are added!

     */
    public int minPatches(int[] nums, int n) {

        long boundry = 1;
        int noPatches = 0;

        int index=0;

        while (boundry<=n){
            if(index<nums.length && nums[index]<=boundry){
                final int num = nums[index];
                boundry+=num;
                index++;
            }else {
                boundry+=boundry;
                noPatches++;
            }
        }

        return noPatches;

    }
}
