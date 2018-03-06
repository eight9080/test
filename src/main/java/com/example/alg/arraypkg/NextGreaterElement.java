package com.example.alg.arraypkg;

import java.util.*;

public class NextGreaterElement {

    /**
     * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
     * <p>
     * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
     * <p>
     * Example 1:
     * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * Output: [-1,3,-1]
     * Explanation:
     * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
     * For number 1 in the first array, the next greater number for it in the second array is 3.
     * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
     * Example 2:
     * Input: nums1 = [2,4], nums2 = [1,2,3,4].
     * Output: [3,-1]
     * Explanation:
     * For number 2 in the first array, the next greater number for it in the second array is 3.
     * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> nextGreaterElement = new HashMap<>();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int num : nums2) {

            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterElement.put(stack.pop(), num);
            }

            stack.push(num);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterElement.getOrDefault(nums1[i], -1);
        }

        return result;
    }


    /**
     * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
     * <p>
     * Example 1:
     * Input: [1,2,1]
     * Output: [2,-1,2]
     * Explanation: The first 1's next greater number is 2;
     * The number 2 can't find next greater number;
     * The second 1's next greater number needs to search circularly, which is also 2.
     */
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            stack.push(i);
        }

        int[] result = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = -1;
            while (!stack.isEmpty()) {
                if (nums[stack.peek()] > nums[i]) {
                    break;
                }
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = nums[stack.peek()];
            }
            stack.push(i);
        }

        return result;

    }

    public int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

//        Stack<Integer> stack = new Stack<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            stack.push(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            result[i] = -1;
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = nums[stack.peek()];
            }
            stack.push(i);
        }

        return result;
    }
}
