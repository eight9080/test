package com.example.alg.arraypkg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchArray {

    /**
     * Given a sorted array and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * You may assume no duplicates in the array.
     * <p>
     * Here are few examples.
     * <p>
     * [1,3,5,6], 5 -> 2
     * [1,3,5,6], 2 -> 1
     * [1,3,5,6], 7 -> 4
     * [1,3,5,6], 0 -> 0
     */
    public static int searchInsert(int[] nums, int target) {
        if (nums == null)
            return -1;
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        int i = 0;
        int j = nums.length;

        while (i < j) {
            int m = (i + j) / 2;
            if (target > nums[m]) {
                i = m + 1;
            } else {
                j = m;
            }

        }
        return j;
    }


    /**
     * Given an array of size n, the goal is to find out the smallest number that is
     * repeated exactly ‘k’ times where k > 0?
     * And
     * <p>
     * Examples:
     * <p>
     * Input : a[] = {2, 1, 3, 1, 2, 2}
     * k = 3
     * Output : 2
     * <p>
     * Input : a[] = {3, 4, 3, 2, 1, 5, 5}
     * k = 2
     * Output : 3
     * Explanation: As 3 is smaller than 5.
     * So 3 should be printed.
     */
    public static Integer searchSmallestNumber(int[] nums, int noOccurrences) {
        final Map<Integer, Integer> mapOccurrences = Arrays.stream(nums).boxed()
                .collect(Collectors.toMap(intValue -> intValue, intValue -> 1,
                        (noOccurrence1, noOccurrence2) -> ++noOccurrence1));
        mapOccurrences.forEach((key, val) -> System.out.println("key " + key + " value " + val));

        final Optional<Integer> smallestElem = mapOccurrences.entrySet().stream()
                .filter(elem -> elem.getValue() == noOccurrences)
                .map(Map.Entry::getKey)
                .sorted()
                .findFirst();

        return smallestElem.orElse(null);
    }

    /**
     * Given a sorted array of integers, find the starting and ending position of a given target value.
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * If the target is not found in the array, return [-1, -1].
     * For example, given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
     */
    public int[] searchRange(int[] nums, int target) {
        final int[] positions = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return positions;
        }

        int low = 0;
        int high = nums.length - 1;

        while (high >= low) {
            int mid = (low + high) / 2;
            final int middleNum = nums[mid];
            if (middleNum == target) {
                int j = mid;
                while (j - 1 >= 0 && nums[j - 1] == target) {
                    j--;
                }
                int k = mid;
                while (k + 1 < nums.length && nums[k + 1] == target) {
                    k++;
                }
                positions[0] = j;
                positions[1] = k;
                break;
            } else if (middleNum < target) {
                low = mid + 1;
            } else if (middleNum > target) {
                high = mid - 1;
            }
        }
        return positions;
    }

    /**
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * <p>
     * You are given a target value to search. If found in the array return its index,
     * otherwise return -1. You may assume no duplicate exists in the array.
     */
    public int searchRotateArrayR(int[] nums, int target) {
        return binarySearchRecursive(nums, 0, nums.length - 1, target);
    }

    private int binarySearchRecursive(int[] nums, int left, int right, int target) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        final int midElem = nums[mid];

        if (midElem == target) {
            return mid;
        }
        if (nums[left] < midElem) {
            if (nums[left] <= target && target < midElem) {
                return binarySearchRecursive(nums, left, mid - 1, target);
            } else {
                return binarySearchRecursive(nums, mid + 1, right, target);
            }
        } else {
            if (midElem < target && target <= nums[right]) {
                return binarySearchRecursive(nums, mid + 1, right, target);
            } else {
                return binarySearchRecursive(nums, left, mid - 1, target);
            }
        }

    }

    public int searchRotateArrayI(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            final int midElem = nums[mid];
            if (midElem == target) {
                return mid;
            }
            if (nums[left] <= midElem) {
                if (nums[left] <= target && target < midElem) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (midElem < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }


    public boolean searchRotateArrayIDuplicate(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            final int midElem = nums[mid];
            if (midElem == target) {
                return true;
            }

            if (nums[left] < midElem) {
                if (nums[left] <= target && target < midElem) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > midElem) {
                if (midElem < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left++;
            }

        }
        return false;
    }


    /**
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * <p>
     * Find the minimum element.You may assume no duplicate exists in the array.
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            final int midElem = nums[mid];

            if (mid - 1 >= 0 && nums[mid - 1] > midElem) {
                return midElem;
            }
            if (mid + 1 < nums.length && midElem > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[left] < midElem) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return nums[left];
    }

    public int findMinDuplicates(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left < right) {

            if (nums[left] < nums[right]) {
                return nums[left];
            }

            int mid = (left + right) / 2;
            final int midElem = nums[mid];

            if (mid - 1 >= 0 && nums[mid - 1] > midElem) {
                return midElem;
            }
            if (mid + 1 < nums.length && midElem > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[left] < midElem) {
                left = mid + 1;
            } else if (nums[left] > midElem) {
                right = mid - 1;
            } else {
                left++;
            }

        }

        return nums[left];
    }

    /**
     * Given an unsorted integer array, find the first missing positive integer.
     * <p>
     * For example,
     * Given [1,2,0] return 3,
     * and [3,4,-1,1] return 2.
     * <p>
     * Your algorithm should run in O(n) time and uses constant space.
     */
    public int firstMissingPositive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 1;
        }

        if (nums.length == 1) {
            final int num = nums[0];
            if (num == 1) {
                return num + 1;
            }
            return 1;
        }

        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= 0 || nums[i] > nums.length || nums[i] == i + 1) {
                i++;
                continue;
            }
            if (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
                continue;
            }
            i++;
        }

        int j = 0;
        while (j < nums.length) {
            if (nums[j] != j + 1) {
                break;
            }
            j++;
        }
        return j + 1;

    }

    /**
     * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
     * <p>
     * Example 1
     * <p>
     * Input: [3,0,1]
     * Output: 2
     * Example 2
     * <p>
     * Input: [9,6,4,2,3,5,7,0,1]
     * Output: 8
     **/
    public int missingNumber(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        if(nums.length==1){
            return nums[0]!=0 ? 0 :1;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i!= nums[i]){
                return i;
            }
        }
        return nums.length;
    }

}
