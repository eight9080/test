package com.example.alg.arraypkg;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.

 Example :
 Input:
 S = "abcde"
 words = ["a", "bb", "acd", "ace"]
 Output: 3
 Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".

 */
public class NumMatchingSequencing {

    public int numMatchingSubseq(String S, String[] words) {

        Map<Character, Deque<String>> map = new HashMap<>();
        for (String word: words) {
            map.compute(word.charAt(0), (key, value) -> {
                if(value==null){
                    value=new ArrayDeque<>();
                }
                value.addLast(word);
                return value;
            });
        }

        int foundSeq = 0;

        for (int i = 0; i < S.length(); i++) {
            final char character = S.charAt(i);
            Deque<String> sequences = map.get(character);
            if(sequences==null){
                sequences = new ArrayDeque<>();
                map.put(character, sequences);
            }
            final int noSeq = sequences.size();
            for (int j = 0; j < noSeq; j++) {
                final String seq = sequences.removeFirst();
                if(seq.length()==1){
                    foundSeq++;
                }else {
                    final char nextCharacter = seq.charAt(1);
                    map.putIfAbsent(nextCharacter, new ArrayDeque<>());
                    map.get(nextCharacter).addLast(seq.substring(1));
                }
            }
        }
        return foundSeq;
    }
}
