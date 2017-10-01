package com.example.alg.stringpck;

import java.util.*;

import static java.util.Arrays.asList;

public class Palindrome {

    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters
     * and ignoring cases.

     For example, "Red rum, sir, is murder" is a palindrome, while "Programcreek is awesome" is not.
     */
    public static boolean isValidPalindrome(String s){
        if(s==null || s.length()==0){
            return false;
        }

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    /**
     * Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list,
     * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

     Example 1:
     Given words = ["bat", "tab", "cat"]
     Return [[0, 1], [1, 0]]
     The palindromes are ["battab", "tabbat"]
     */
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();

        HashMap<String, Integer> mapIndex = new HashMap<>();
        for(int i=0; i<words.length; i++){
            mapIndex.put(words[i], i);
        }

        for(int i = 0; i< words.length; i++){
            String word = words[i];

            //if the word is a palindrome, get index of ""
            if(isPalindrome(word)){
                final Optional<Integer> pairWordIndex = findPairIndex("", i, mapIndex);
                if(pairWordIndex.isPresent()){
                    result.add(asList( i, pairWordIndex.get()));
                    result.add(asList( pairWordIndex.get(), i));
                }
            }

            final Optional<Integer> pairWordIndex = findPairIndex(word, i, mapIndex);
            if(pairWordIndex.isPresent()){
                result.add(asList( i, pairWordIndex.get()));
            }

            for(int k=1; k<word.length(); k++) {
                String left = word.substring(0, k);
                String right = word.substring(k);

                if(isPalindrome(left)){
                    final Optional<Integer> pairIndex = findPairIndex(right, i, mapIndex);
                    if(pairIndex.isPresent()){
                        result.add(asList( pairIndex.get(), i));
                    }
                }
                if(isPalindrome(right)){
                    final Optional<Integer> pairIndex = findPairIndex(left, i, mapIndex);
                    if(pairIndex.isPresent()){
                        result.add(asList( i, pairIndex.get()));
                    }
                }

            }
        }

        return result;
    }

    private static Optional<Integer> findPairIndex(String word, Integer wordIndex, Map<String, Integer> mapIndex){
        final String reverseWord = "".equals(word)? "" : new StringBuilder(word).reverse().toString();
        if(mapIndex.containsKey(reverseWord)){
            final Integer reverseWordIndex = mapIndex.get(reverseWord);
            if(!Objects.equals(reverseWordIndex, wordIndex)){
                return Optional.of(reverseWordIndex);
            }
        }
        return Optional.empty();
    }

    private static boolean isPalindrome(String word) {
        int i= 0;
        int j = word.length()-1;

        while (i<j){
            if(word.charAt(i) != word.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
