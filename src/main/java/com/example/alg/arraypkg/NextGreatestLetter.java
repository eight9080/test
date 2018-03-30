package com.example.alg.arraypkg;

/**
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.
 * <p>
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 * <p>
 * Examples:
 * Input:
 * letters = ["c", "f", "j"]
 * target = "a"
 * Output: "c"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "c"
 * Output: "f"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "g"
 * Output: "j"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "j"
 * Output: "c"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 */
public class NextGreatestLetter {


    public char nextGreatestLetter(char[] letters, char target) {

        if (letters[0] > target) {
            return letters[0];
        }
        if (letters[letters.length - 1] <= target) {
            return letters[0];
        }

        int left = 0;
        int right = letters.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (target < letters[mid]) {
                right = mid-1;
            } else {
                left = mid+1;
            }

        }

        return letters[left];

    }

}
