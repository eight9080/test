package com.example.alg.stringpck;

import java.util.*;

public class FindUnique {

    /**
     * Given a string, find the first non-repeating character in it and
     * return it's index. If it doesn't exist, return -1.

     Examples:

     s = "leetcode"
     return 0.

     s = "loveleetcode",
     return 2.
     */
    public int firstUniqChar(String s) {
        if(s==null || s.length()==0){
            return -1;
        }
        if(s.length()==1){
            return 0;
        }

        Set<Character> charactersFound = new HashSet<>();
        Map<Character, Integer> characterByPosition = new HashMap<>();

        for (int i = 0; i <s.length(); i++) {
            final Character c = s.charAt(i);
            if(!charactersFound.contains(c)){
                charactersFound.add(c);
                characterByPosition.put(c, i);
            }else {
                characterByPosition.remove(c);
            }
        }
        if(characterByPosition.isEmpty()){
            return -1;
        }

        return characterByPosition.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(-1);


    }
}
