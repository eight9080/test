package com.example.alg.stringpck;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CountingDuplicates {
    /**
     * Count the number of Duplicates
     Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string. The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.

     Example
     "abcde" -> 0 # no characters repeats more than once
     "aabbcde" -> 2 # 'a' and 'b'
     "aabBcde" -> 2 # 'a' occurs twice and 'b' twice (bandB)
     "indivisibility" -> 1 # 'i' occurs six times
     "Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
     "aA11" -> 2 # 'a' and '1'
     "ABBA" -> 2 # 'A' and 'B' each occur twice
     */
    public static int duplicateCount(String text) {
        if(text==null || text.length()==0){
            return 0;
        }
        final Map<Integer, Integer> collect = text.toLowerCase().chars().boxed()
                .collect(Collectors.toMap(identity(), v -> 1, (a, b) -> a + b));
        final long count = collect.values().stream().filter(v -> v > 1).count();
        return (int)count;


    }

    private static Map<Character, Long> charFrequenciesMap(final String text) {
        return text.codePoints()
                .map(Character::toLowerCase)
                .mapToObj(c -> (char) c)
                .collect(groupingBy(identity(), counting()));
    }

    public static int duplicateCount2(final String text) {
        return (int) charFrequenciesMap(text).values().stream()
                .filter(i -> i > 1)
                .count();
    }
}
