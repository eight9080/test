package com.example.alg.stringpck;

import java.util.ArrayDeque;
import java.util.Deque;

public class CompareVersion {

    /**
     * Compare two version numbers version1 and version2.
     If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

     You may assume that the version strings are non-empty and contain only digits and the . character.
     The . character does not represent a decimal point and is used to separate number sequences.
     For instance, 2.5 is not "two and a half" or "half way to version three",
     it is the fifth second-level revision of the second first-level revision.

     Here is an example of version numbers ordering:

     0.1 < 1.1 < 1.2 < 13.37
     */
    public int compareVersion(String version1, String version2) {
        final String[] v1 = version1.split("\\.");
        final String[] v2 = version2.split("\\.");

        int i = 0;
        while (i<v1.length || i <v2.length){
            if(i<v1.length && i <v2.length){
                final Integer partV1 = Integer.valueOf(v1[i]);
                final Integer partV2 = Integer.valueOf(v2[i]);
                if(partV1<partV2){
                    return -1;
                }else if(partV1>partV2){
                    return 1;
                }
            }else {
                if(i<v1.length){
                    final Integer partV1 = Integer.valueOf(v1[i]);
                    if(partV1!=0){
                        return 1;
                    }
                }
                if(i<v2.length){
                    final Integer partV2 = Integer.valueOf(v2[i]);
                    if(partV2!=0){
                        return -1;
                    }
                }
            }

            i++;
        }


        return 0;
    }

    /**
     * 844. Backspace String Compare
     * Given two strings S and T, return if they are equal when both are typed into empty text editors.
     * # means a backspace character.
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        return buildString(S).equals(buildString(T));
    }


    private String buildString(String text){
        Deque<Character> stack = new ArrayDeque<>();

        for(char character : text.toCharArray()){
            if(character!='#'){
                stack.push(character);
            }else {
                stack.poll();
            }
        }
        return String.valueOf(stack);
    }

}
