package com.example.alg.stringpck;

import java.util.*;

public class Anagrams {

    /**
     * Given an array of strings, group anagrams together.
     For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], Return:
     [
     ["ate", "eat","tea"],
     ["nat","tan"],
     ["bat"]
     ]
     Note: All inputs will be in lower-case.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new LinkedHashMap<>();
        for(String word : strs){
            final char[] chars = word.toCharArray();
            Arrays.sort(chars);
            final String sortedWord = new String(chars);
            map.putIfAbsent(sortedWord, new ArrayList<>());
            map.get(sortedWord).add(word);
        }
        map.forEach((key, value) -> Collections.sort(value));

        return new ArrayList<>(map.values());
    }
}
