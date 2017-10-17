package com.example.alg.stringpck;

import java.util.*;

public class SubstringWords {

    /**
     * You are given a string, s, and a list of words, words, that are all of the same length.
     * Find all starting indices of substring(s) in s that is a concatenation of each word in words
     * exactly once and without any intervening characters.

     For example, given:
     s: "barfoothefoobarman"
     words: ["foo", "bar"]

     You should return the indices: [0,9].
     (order does not matter).
     */
    public List<Integer> findSubstring(String s, String[] words) {

        if(words==null || words.length==0){
            return  Collections.emptyList();
        }

        final int wordLength = words[0].length();
        if(s.length()<wordLength){
            return  Collections.emptyList();
        }

        Map<String, Integer> wordsFrequency = new HashMap<>();
        for(String word: words){
            wordsFrequency.putIfAbsent(word, 0);
            wordsFrequency.put(word, wordsFrequency.get(word)+1);
        }

        List<Integer> startPositions = new ArrayList<>();

        for(int j=0; j<wordLength; j++) {
            Map<String, Integer> foundWords = new HashMap<>();
            int noWords = words.length;
            int start = -1;
            int noFoundWords = 0;

            for (int i = j; i <= s.length() - wordLength; i = i + wordLength) {

                final String word = s.substring(i, i + wordLength);

                if (!wordsFrequency.containsKey(word)) {
                    foundWords.clear();
                    noFoundWords = 0;
                    start = i + wordLength;
                    continue;

                }

                if (wordsFrequency.containsKey(word)) {
                    if (start == -1) {
                        start = i;
                    }
                    if (foundWords.containsKey(word)) {
                        foundWords.put(word, foundWords.get(word) + 1);
                        noFoundWords++;
                        while (foundWords.get(word) > wordsFrequency.get(word)) {
                            String startWord = s.substring(start, start + wordLength);
                            foundWords.put(startWord, foundWords.get(startWord) - 1);
                            noFoundWords--;
                            start = start + wordLength;
                        }

                    } else {
                        foundWords.put(word, 1);
                        noFoundWords++;
                    }
                }

                if (noFoundWords == noWords) {
                    startPositions.add(start);
                    final String startWord = s.substring(start, start + wordLength);
                    if (foundWords.get(startWord) == 1) {
                        foundWords.remove(startWord);
                    } else {
                        foundWords.put(startWord, foundWords.get(word) - 1);
                    }
                    noFoundWords--;
                    start = start + wordLength;
                }


            }
        }



        return startPositions;

    }
}
