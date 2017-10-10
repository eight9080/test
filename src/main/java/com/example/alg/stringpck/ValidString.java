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
}
