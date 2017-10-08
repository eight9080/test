package com.example.alg.stringpck;

public class ReverseVowels {
    /**
     * Write a function that takes a string as input and reverse only the vowels of a string.
     Example 1:
     Given s = "hello", return "holle".
     Example 2:
     Given s = "leetcode", return "leotcede".
     NOTICE THAT left cannot go beyond right, otherwise you end up swap already swapped pairs.
     */
    public static String reverseVowels(String word) {
        if(word==null || word.length()<=1){
            return word;
        }
        String dict = "aeiouAEIOU";
        final char[] chars = word.toCharArray();
        int left = 0;
        int right = chars.length-1;

        while (left<right){
            while(left<chars.length && dict.indexOf(chars[left])==-1){
                left++;
            }
            if(left>=chars.length || left>right) break;
            while(right>=0 && dict.indexOf(chars[right])==-1){
                right--;
            }
            if(right<0 || right<left) break;

            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }

        return new String(chars);
    }
}
