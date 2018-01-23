package com.example.alg.mappck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {
    /**
     * This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

     Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

     For example,
     Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

     Given word1 = “coding”, word2 = “practice”, return 3.
     Given word1 = "makes", word2 = "coding", return 1.
     */
    private Map<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            final int position = i;
            map.compute(words[i], (k, v1) -> {
                if(v1==null){
                    v1=new ArrayList<>();
                }
                v1.add(position);
                return v1;
            });
        }

    }
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);

        int result = Integer.MAX_VALUE;

        int i = 0;
        int j=0;

        while (i<l1.size() && j<l2.size()){

            Integer i1 = l1.get(i);
            Integer i2 = l2.get(j);
            result = Math.min(result, Math.abs(i1-i2));
            if(i1<i2){
                i++;
            }else {
                j++;
            }
        }

        return result;
    }

    public int shortest2(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);

        int result = Integer.MAX_VALUE;
        for(int i1: l1){
            for(int i2: l2){
                result = Math.min(result, Math.abs(i1-i2));
            }
        }
        return result;
    }
}
