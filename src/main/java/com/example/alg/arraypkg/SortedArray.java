package com.example.alg.arraypkg;

public class SortedArray {
    /**
     * Given a sorted array, remove the duplicates in place such that each element appear
     * only once and return the new length.
     * <p>
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     * <p>
     * For example,
     * Given input array nums = [1,1,2],
     * <p>
     * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
     * It doesn't matter what you leave beyond the new length.
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int noDuplicate = 0;
        int position = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[position]) {
                noDuplicate++;

            } else {
                nums[++position] = nums[i];
            }

        }
        return nums.length - noDuplicate;

    }

    /**
     * Follow up for "Remove Duplicates":
     * What if duplicates are allowed at most twice?
     * <p>
     * For example,
     * Given sorted array nums = [1,1,1,2,2,3],
     * <p>
     * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
     * It doesn't matter what you leave beyond the new length.
     */
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int extraDuplicateElement = 1;
        if (nums.length < 2) {
            return nums.length;
        }
        int noDuplicate = 0;
        int position = 0;
        int currentDuplicates = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[position]) {
                if (currentDuplicates < extraDuplicateElement) {
                    nums[++position] = nums[i];
                    currentDuplicates++;
                } else {
                    noDuplicate++;
                }

            } else {
                nums[++position] = nums[i];
                currentDuplicates = 0;
            }

        }
        return nums.length - noDuplicate;
    }


    /**
     * You are given a sorted array containing only numbers 0 and 1. Find the transition point efficiently. Transition point is a point where "0" ends and "1" begins.
     * <p>
     * Input:
     * <p>
     * You have to complete the method which takes 2 argument: the array arr[] and size of array N. You should not read any input from stdin/console. There are multiple test cases. For each test cases, this method will be called individually.
     * <p>
     * Output:
     * <p>
     * Your function should return transition point.
     * <p>
     * Constraints:
     * <p>
     * 1 ≤ T ≤ 100
     * 1 ≤ N ≤ 500000
     * 0 ≤ C[i] ≤ 1
     * <p>
     * Example:
     * <p>
     * Input
     * 1
     * 5
     * 0 0 0 1 1
     * <p>
     * Output
     * 3
     */
    int transitionPoint(int arr[], int n) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (arr[middle] == 0) {
                start = middle + 1;
                continue;
            }
            if (arr[middle - 1] == 0) {
                return middle;
            }
            end = middle - 1;
        }
        return -1;
    }


    /**
     * Given two sorted arrays.
     * There is only 1 difference between the arrays.
     * First array has one element extra added in between.
     * Find the index of the extra element.
     */
    public int findExtra(int a[], int b[], int n) {

        int start = 0;
        int end = a.length > b.length ? b.length - 1 : a.length - 1;

        int indexResult = a.length>b.length?a.length-1:b.length-1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] == b[mid]) {
                start = mid + 1;
                continue;
            }
            indexResult = mid;
            end = mid - 1;
        }

        return indexResult;
    }

}
