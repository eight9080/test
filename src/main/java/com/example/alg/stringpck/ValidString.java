package com.example.alg.stringpck;

import java.util.*;
import java.util.stream.Collectors;

public class ValidString {
    /**
     * Sherlock considers a string, , to be valid if either of the following conditions are satisfied:

     All characters in  have the same exact frequency (i.e., occur the same number of times).
     For example,  is valid, but  is not valid.
     Deleting exactly  character from  will result in all its characters having the same frequency.
     For example,  and  are valid because all their letters will have the same frequency if we remove occurrence of c,
     but  is not valid because we'd need to remove  characters.
     Given , can you determine if it's valid or not? If it's valid, print YES on a new line; otherwise,
     print NO instead.
     */
    static String isValid(String s){
        // Complete this function
        Map<Character, Integer> characterFrequency  = new HashMap<>();
        final char[] chars = s.toCharArray();
        for (char c: chars) {
            final Integer frequency = characterFrequency.getOrDefault(c, 0);
            characterFrequency.put(c, frequency+1);
        }
        final List<Integer> frequencies = new ArrayList<>(characterFrequency.values());
        if(frequencies.size()<=1) return "YES";

        int freq = frequencies.get(0);
        boolean foundCharacterToDelete = false;

        for(int i = 1; i< frequencies.size(); i++){
            final Integer currentFrequency = frequencies.get(i);
            if(currentFrequency==freq) continue;
            if(foundCharacterToDelete) return "NO";
            if(freq==1 && i==1){
                freq=currentFrequency;
                foundCharacterToDelete=true;
                continue;
            }

            if(currentFrequency==1 || Math.abs(currentFrequency-freq)==1){
                foundCharacterToDelete=true;
                continue;
            }
            return "NO";
        }
        return "YES";

    }


    /**
     * Given a word, you need to judge whether the usage of capitals in it is right or not.

     We define the usage of capitals in a word to be right when one of the following cases holds:

     All letters in this word are capitals, like "USA".
     All letters in this word are not capitals, like "leetcode".
     Only the first letter in this word is capital if it has more than one letter, like "Google".
     Otherwise, we define that this word doesn't use capitals in a right way.
     Example 1:
     Input: "USA"
     Output: True
     Example 2:
     Input: "FlaG"
     Output: False
     */
    public boolean detectCapitalUse(String word) {

        if(word==null || word.isEmpty() || word.length()==1){
            return true;
        }

        boolean firstLetter = Character.isUpperCase(word.charAt(0));
        boolean secondLetter = Character.isUpperCase(word.charAt(1));

        if(secondLetter && !firstLetter){
            return false;
        }

        boolean allCapital = firstLetter && secondLetter;


        for (int i = 2; i < word.length(); i++) {
            final boolean upperCase = Character.isUpperCase(word.charAt(i));
            if(upperCase && !allCapital){
                return false;
            }
            if(!upperCase && allCapital){
                return false;
            }

        }
        return true;
    }

    public boolean detectCapitalUseReg(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }

}
