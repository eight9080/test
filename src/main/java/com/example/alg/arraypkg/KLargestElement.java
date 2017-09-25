package com.example.alg.arraypkg;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 * <p>
 * For example, given [3,2,1,5,6,4] and k = 2, return 5.
 */
public class KLargestElement {

    public static int findKthLargest(int[] nums, int k) {
        final PriorityQueue<Integer> q = new PriorityQueue<>(k);
        for (int i : nums) {
            q.offer(i);
            System.out.println(q);
            if (q.size() > k) {
                q.poll();
                System.out.println(q);
            }
        }
        return q.peek();
    }

    public static int findKthLargestQuickSort(int[] nums, int k) {
        if (k < 1 || nums == null) {
            return 0;
        }

        return getKth(nums.length - k +1, nums, 0, nums.length - 1);
    }

    public static int getKth(int k, int[] nums, int start, int end) {

        int pivot = nums[end];

        int left = start;
        int right = end;

        while (true) {

            while (nums[left] < pivot && left < right) {
                left++;
            }

            while (nums[right] >= pivot && right > left) {
                right--;
            }

            if (left == right) {
                break;
            }

            swap(nums, left, right);
            System.out.println(Arrays.toString(nums));
        }

        swap(nums, left, end);
        System.out.println("Nums: "+ Arrays.toString(nums));

        if (k == left + 1) {
            return pivot;
        } else if (k < left + 1) {
            return getKth(k, nums, start, left - 1);
        } else {
            return getKth(k, nums, left + 1, end);
        }
    }

    private static void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }


}
