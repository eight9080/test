package com.example.alg.stringpck;

import java.util.*;

public class SubstringWords {

    /**
     * You are given a string, s, and a list of words, words, that are all of the same length.
     * Find all starting indices of substring(s) in s that is a concatenation of each word in words
     * exactly once and without any intervening characters.
     * <p>
     * For example, given:
     * s: "barfoothefoobarman"
     * words: ["foo", "bar"]
     * <p>
     * You should return the indices: [0,9].
     * (order does not matter).
     */
    public List<Integer> findSubstring(String s, String[] words) {

        if (words == null || words.length == 0) {
            return Collections.emptyList();
        }

        final int wordLength = words[0].length();
        if (s.length() < wordLength) {
            return Collections.emptyList();
        }

        Map<String, Integer> wordsFrequency = new HashMap<>();
        for (String word : words) {
            wordsFrequency.putIfAbsent(word, 0);
            wordsFrequency.put(word, wordsFrequency.get(word) + 1);
        }

        List<Integer> startPositions = new ArrayList<>();

        for (int j = 0; j < wordLength; j++) {
            Map<String, Integer> foundWords = new HashMap<>();
            int noWords = words.length;
            int start = -1;
            int noFoundWords = 0;

            for (int i = j; i <= s.length() - wordLength; i = i + wordLength) {

                final String word = s.substring(i, i + wordLength);

                if (!wordsFrequency.containsKey(word)) {
                    foundWords.clear();
                    noFoundWords = 0;
                    start = i + wordLength;
                    continue;

                }

                if (wordsFrequency.containsKey(word)) {
                    if (start == -1) {
                        start = i;
                    }
                    if (foundWords.containsKey(word)) {
                        foundWords.put(word, foundWords.get(word) + 1);
                        noFoundWords++;
                        while (foundWords.get(word) > wordsFrequency.get(word)) {
                            String startWord = s.substring(start, start + wordLength);
                            foundWords.put(startWord, foundWords.get(startWord) - 1);
                            noFoundWords--;
                            start = start + wordLength;
                        }

                    } else {
                        foundWords.put(word, 1);
                        noFoundWords++;
                    }
                }

                if (noFoundWords == noWords) {
                    startPositions.add(start);
                    final String startWord = s.substring(start, start + wordLength);
                    if (foundWords.get(startWord) == 1) {
                        foundWords.remove(startWord);
                    } else {
                        foundWords.put(startWord, foundWords.get(word) - 1);
                    }
                    noFoundWords--;
                    start = start + wordLength;
                }


            }
        }


        return startPositions;

    }

    /**
     * Given a string, find the longest substring that contains only two unique characters.
     * For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character is "bcbbbbcccb".
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int max = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }


            if (map.size() < 2) {
                continue;
            }
            max = Math.max(max, i-start);

            while (map.size()>2){
                final char startCharacter = s.charAt(start);
                int count = map.get(startCharacter);
                if(count>1){
                    map.put(startCharacter, count-1);
                }else{
                    map.remove(startCharacter);
                }
                start++;
            }
        }
        max = Math.max(max, s.length()-start);

        return max;

    }


    /**
     * The following solution is corrected.
     * Given "abcadcacacaca" and 3, it returns "cadcacacaca".
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s == null || s.length() == 0)
            return 0;

        if(k>s.length()){
            return 0;
        }

        int max = 0;
        int start = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
            if(map.size()<=k){
                continue;
            }
            max = Math.max(max, i-start);

            while (map.size()>k){
                final char c1 = s.charAt(start);
                int count = map.get(c1);
                if(count>1){
                    map.put(c1, count-1);
                }else{
                    map.remove(c1);
                }
                start++;
            }

        }

        max = Math.max(max, s.length()-start);



        return max;
    }


    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
     * return the length of last word in the string.

     If the last word does not exist, return 0.

     Note: A word is defined as a character sequence consists of non-space characters only.

     For example,
     Given s = "Hello World",
     return 5.
     */
    public int lengthOfLastWord(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        final String[] parts = s.trim().split("\\s+");
        return parts[parts.length-1].length();

    }

    /**
     * Given a string, find the length of the longest substring without repeating characters.

     Examples:

     Given "abcabcbb", the answer is "abc", which the length is 3.

     Given "bbbbb", the answer is "b", with the length of 1.

     Given "pwwkew", the answer is "wke", with the length of 3.
     Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


     */
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start=0;
        int length = 0;

        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);

            if(!map.containsKey(c)){
                map.put(c, 1);
                length++;
                continue;
            }
            max=Math.max(max, length);
            while (map.containsKey(c)){
                map.remove(s.charAt(start));
                start++;
                length--;
            }
            map.put(c,1);
            length++;
        }
        max=Math.max(max, length);
        return max;
    }
}
