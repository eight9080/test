package com.example.alg.stringpck;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
 * <p>
 * We can define a map which tracks the char-char mappings.
 * If a value is already mapped, it can not be mapped again.
 */
public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        final Map<Character, Character> mapFromSToT = new HashMap<>();

        for(int i = 0; i< s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(mapFromSToT.containsKey(c1)){
                if(mapFromSToT.get(c1)!=c2){
                    return false;
                }
            }else{
                if(mapFromSToT.containsValue(c2)){
                    return false;
                }
                mapFromSToT.put(c1, c2);
            }

        }
        return true;
    }
}
