package com.example.alg.stringpck;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountSegments {

    /**
     * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

     Please note that the string does not contain any non-printable characters.

     Example:

     Input: "Hello, my name is John"
     Output: 5
     */
    public int countSegments(String s) {

        if(s==null ){
            return 0;
        }

        final String input = s.trim();

        if(input.length()==0){
            return 0;
        }

        final String[] parts = input.split("\\s+");

        return parts.length;

    }

    /**
     * 819. Most Common Word
     * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words. It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
     *
     * Words in the list of banned words are given in lowercase, and free of punctuation. Words in the paragraph are not case sensitive. The answer is in lowercase.
     *
     */
    public String mostCommonWord(String paragraph, String[] banned) {

        final Set<String> bannedWords = Arrays.stream(banned).collect(Collectors.toSet());
        final String[] words = paragraph.replaceAll("\\W+", " ")
                .toLowerCase().split("\\s+");

        final Map<String, Integer> wordsByFrequency = Arrays.stream(words)
                .filter(word -> !bannedWords.contains(word))
                .collect(
                        Collectors.toMap(Function.identity(), word -> 1,
                                (oldValue, newValue) -> oldValue + 1));

        return Collections.max(wordsByFrequency.entrySet(), Map.Entry.comparingByValue()).getKey();

    }

}
