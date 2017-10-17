package com.example.alg.stringpck;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    /**
     * Given a string S and a string T, find the minimum window in S which will contain all the characters in T
     * in complexity O(n).

     For example,
     S = "ADOBECODEBANC"
     T = "ABC"
     Minimum window is "BANC".

     Note:
     If there is no such window in S that covers all characters in T, return the empty string "".

     If there are multiple such windows, you are guaranteed that there will always be
     only one unique minimum window in S.
     */
    public String minWindow(String s, String t) {

        if(t.length()>s.length())
            return "";
        String result = "";

        Map<Character, Integer> tByCharacter = new HashMap<>();
        for(int i = 0; i<t.length(); i++){
            final char c = t.charAt(i);
            tByCharacter.putIfAbsent(c, 0);
            tByCharacter.put(c, tByCharacter.get(c)+1);
        }
        Map<Character, Integer> sByCharacter = new HashMap<>();

        int left = 0;
        int minLen = s.length()+1;

        int foundCharacters = 0;// the total of mapped characters
        for(int i = 0; i<s.length(); i++){
            final char c = s.charAt(i);

            if(tByCharacter.containsKey(c)){
                if(sByCharacter.containsKey(c)){
                    if(sByCharacter.get(c)<tByCharacter.get(c)){
                        foundCharacters++;
                    }
                    sByCharacter.put(c, sByCharacter.get(c)+1);
                }else {
                    sByCharacter.put(c, 1);
                    foundCharacters++;
                }
            }


            if(foundCharacters==t.length()){
                char leftCh = s.charAt(left);
                while (!sByCharacter.containsKey(leftCh) || sByCharacter.get(leftCh)>tByCharacter.get(leftCh)){
                    if(sByCharacter.containsKey(leftCh) && sByCharacter.get(leftCh)>tByCharacter.get(leftCh)) {
                        sByCharacter.put(leftCh, sByCharacter.get(c)-1);
                    }
                        left++;
                        leftCh=s.charAt(left);
                }
                if(i-left+1<minLen){
                    result = s.substring(left, i+1);
                    minLen = i-left+1;
                }
            }

        }

        return result;
    }
}
