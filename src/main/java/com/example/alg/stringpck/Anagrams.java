package com.example.alg.stringpck;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;

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

    /**
     * Given two strings s and t, write a function to determine if t is an anagram of s.

     For example,
     s = "anagram", t = "nagaram", return true.
     s = "rat", t = "car", return false.
     */
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()){
            return false;
        }

        final Map<Character, Long> characters = s.codePoints()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(identity(), counting()));

        for (int i = 0; i < t.length(); i++) {
            final char c = t.charAt(i);
            if(!characters.containsKey(c)){
                return false;
            }
            Long freq = characters.get(c);
            if(freq<=0){
                return false;
            }
            freq--;
            if(freq==0){
                characters.remove(c);
            }else {
                characters.put(c, freq);
            }
        }

        return characters.isEmpty();
    }
}
