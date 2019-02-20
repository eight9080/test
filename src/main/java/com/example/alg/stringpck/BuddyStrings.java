package com.example.alg.stringpck;

import java.util.*;

/**
 * 859. Buddy Strings
 * Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
 *
 *
 *
 * Example 1:
 *
 * Input: A = "ab", B = "ba"
 * Output: true
 * Example 2:
 *
 * Input: A = "ab", B = "ab"
 * Output: false
 * Example 3:
 *
 * Input: A = "aa", B = "aa"
 * Output: true
 * Example 4:
 *
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * Example 5:
 *
 * Input: A = "", B = "aa"
 * Output: false
 */
public class BuddyStrings {

    public boolean buddyStrings(String A, String B) {

        if(A.length()!=B.length()){
            return false;
        }

        if(A.equals(B)){
            Set<Character> uniqueChars = new HashSet<>();
            for (int i = 0; i < A.length(); i++) {
                if(uniqueChars.contains(A.charAt(i))){
                    return true;
                }
                uniqueChars.add(A.charAt(i));
            }
            return false;
        }

        List<List<Character>> different = new ArrayList<>();

        for (int i = 0; i < A.length(); i++) {
            if(A.charAt(i)!=B.charAt(i)){
                if(different.size()>1){
                    return false;
                }
                different.add(Arrays.asList(A.charAt(i), B.charAt(i)));
            }
        }
        if(different.size()!=2){
            return false;
        }

        final List<Character> ch1 = different.get(0);
        final List<Character> ch2 = different.get(1);

        return ch1.get(0)==ch2.get(1) && ch1.get(1)==ch2.get(0);
    }

}
