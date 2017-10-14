package com.example.alg.arraypkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LongestCommonPrefix {

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.

     Analysis

     To solve this problem, we need to find the two loop conditions.
     One is the length of the shortest string.
     The other is iteration over every element of the string array.
     */

    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }

        if(strs.length==1){
            return strs[0];
        }

        int lenPrefix = 0;

        for (int i = 0; i< strs.length-1; i++) {
            final char[] charsWord1 = strs[i].toCharArray();
            final char[] charsWord2 = strs[i+1].toCharArray();

            int len = Math.min(charsWord1.length, charsWord2.length);
            if(lenPrefix!=0){
                len = Math.min(lenPrefix, len);
            }
            lenPrefix=0;

            for(int j = 0; j< len; j++){
                if (charsWord1[j] != charsWord2[j]) {
                    break;
                }
                lenPrefix++;
            }
            if(lenPrefix==0){
                break;
            }
        }


        if(lenPrefix>0) {
            return strs[0].substring(0, lenPrefix);
        }else{
            return "";
        }
    }

}
