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

    /**
     * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

     Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

     The order of output does not matter.

     Example 1:

     Input:
     s: "cbaebabacd" p: "abc"

     Output:
     [0, 6]

     Explanation:
     The substring with start index = 0 is "cba", which is an anagram of "abc".
     The substring with start index = 6 is "bac", which is an anagram of "abc".
     Example 2:

     Input:
     s: "abab" p: "ab"

     Output:
     [0, 1, 2]

     Explanation:
     The substring with start index = 0 is "ab", which is an anagram of "ab".
     The substring with start index = 1 is "ba", which is an anagram of "ab".
     The substring with start index = 2 is "ab", which is an anagram of "ab".
     */
    public List<Integer> findAnagrams1(String s, String p) {

        if(s==null || s.isEmpty() || p==null|| p.isEmpty()){
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();

        final Map<Character, Long> characters = p.codePoints()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(identity(), counting()));
        final char[] charsAnagram = p.toCharArray();
        Arrays.sort(charsAnagram);

        for (int i = 0; i < s.length()-p.length()+1; i++) {
            final char firstCharacter = s.charAt(i);
            if(characters.containsKey(firstCharacter)){
                char[] tempWord = new char[p.length()];
                tempWord[0] = firstCharacter;
                int k = 1;
                for (int j = i+1; j < i+p.length(); j++) {
                    final char c = s.charAt(j);
                    if(characters.containsKey(c)){
                        tempWord[k++]=c;
                    }
                }
                Arrays.sort(tempWord);
                if(Arrays.equals(charsAnagram, tempWord)){
                    result.add(i);
                }
            }
        }

        return result;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[26]; //character hash
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c-'a']++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p

            if (hash[s.charAt(right)-'a'] >= 1) count--;
            hash[s.charAt(right)-'a']--;
            right++;


            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)-'a']++ >= 0) count++;
//            hash[s.charAt(left)]++;
//            left++;
        }
        return list;
    }

}
