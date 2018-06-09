package com.example.alg.stringpck;

import java.util.*;
import java.util.stream.Collectors;

public class FindStrings {


    /**
     * Implement strStr().

     Returns the index of the first occurrence of needle in haystack,
     or -1 if needle is not part of haystack.
     */
    public int strStrSimple(String haystack, String needle){
        if(haystack==null || needle==null){
            return 0;
        }

        if(needle.length()==0){
            return 0;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if(i+needle.length()> haystack.length()){
                return -1;
            }
            int m = i;
            for (int j = 0; j < needle.length(); j++) {
                if(needle.charAt(j)==haystack.charAt(m)){
                    if(j==needle.length()-1){
                        return i;
                    }
                    m++;
                }else{
                    break;
                }

            }
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        if(haystack==null || needle==null)
            return 0;

        int h = haystack.length();
        int n = needle.length();

        if (n > h)
            return -1;
        if (n == 0)
            return 0;

        int[] next = getNext(needle);
        int i = 0;

        while (i <= h - n) {
            int success = 1;
            for (int j = 0; j < n; j++) {
                if (needle.charAt(0) != haystack.charAt(i)) {
                    success = 0;
                    i++;
                    break;
                } else if (needle.charAt(j) != haystack.charAt(i + j)) {
                    success = 0;
                    i = i + j - next[j - 1];
                    break;
                }
            }
            if (success == 1)
                return i;
        }

        return -1;
    }

    //calculate KMP array
    public int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        next[0] = 0;

        for (int i = 1; i < needle.length(); i++) {
            int index = next[i - 1];
            while (index > 0 && needle.charAt(index) != needle.charAt(i)) {
                index = next[index - 1];
            }

            if (needle.charAt(index) == needle.charAt(i)) {
                next[i] = next[i - 1] + 1;
            } else {
                next[i] = 0;
            }
        }

        return next;
    }

    public boolean canConstruct(String ransomNote, String magazine) {

        final Map<Character, Integer> frequency = magazine.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toMap(c -> c, c -> 1, (a, b) -> a + 1));

        for (int i = 0; i < ransomNote.length(); i++) {
            final char c = ransomNote.charAt(i);
            frequency.put(c, frequency.getOrDefault(c, 0)-1);
            if(frequency.get(c)<0){
                return false;
            }
        }
        return true;
    }

    /**
     * We are given N different types of stickers. Each sticker has a lowercase English word on it.
     *
     * You would like to spell out the given target string by cutting individual letters from your collection of stickers and rearranging them.
     *
     * You can use each sticker more than once if you want, and you have infinite quantities of each sticker.
     *
     * What is the minimum number of stickers that you need to spell out the target? If the task is impossible, return -1.
     *
     * Example 1:
     *
     * Input:
     *
     * ["with", "example", "science"], "thehat"
     * Output:
     *
     * 3
     * Explanation:
     *
     * We can use 2 "with" stickers, and 1 "example" sticker.
     * After cutting and rearrange the letters of those stickers, we can form the target "thehat".
     * Also, this is the minimum number of stickers necessary to form the target string.
     * Example 2:
     *
     * Input:
     *
     * ["notice", "possible"], "basicbasic"
     * Output:
     *
     * -1
     * Explanation:
     *
     * We can't form the target "basicbasic" from cutting letters from the given stickers.
     * @param stickers
     * @param target
     * @return
     */
    public int minStickers(String[] stickers, String target) {

        int n = target.length(), N = 1 << n;
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 0; i < N; i++){

            if (dp[i] != Integer.MAX_VALUE) {
                for (String sticker : stickers) {
                    int status = i;
                    for (char c : sticker.toCharArray()) {
                        for (int r = 0; r < n; r++) {
                            int pos = 1 << r;
                            if (target.charAt(r) == c && (pos & status) == 0) {
                                status |= pos;
                                break;
                            }
                        }
                    }
                    dp[status] = Math.min(dp[status], dp[i] + 1);
                }
            }
        }
        return dp[N-1] == Integer.MAX_VALUE ? -1 : dp[N-1];


    }

    private Map<Character, Integer> getCharactersFrequency(String text){
        final Map<Character, Integer> frequency = text.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toMap(c -> c, c -> 1, (a, b) -> a + 1));
        return frequency;
    }

}
