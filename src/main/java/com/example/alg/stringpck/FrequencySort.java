package com.example.alg.stringpck;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class FrequencySort {
    /**
     * Given a string, sort it in decreasing order based on the frequency of characters.

     Example 1:

     Input:
     "tree"

     Output:
     "eert"

     Explanation:
     'e' appears twice while 'r' and 't' both appear once.
     So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
     Example 2:

     Input:
     "cccaaa"

     Output:
     "cccaaa"

     Explanation:
     Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
     Note that "cacaca" is incorrect, as the same characters must be together.
     Example 3:

     Input:
     "Aabb"

     Output:
     "bbAa"

     Explanation:
     "bbaA" is also a valid answer, but "Aabb" is incorrect.
     Note that 'A' and 'a' are treated as two different characters.
     */
    public String frequencySort(String s) {
        if(s==null || s.length()<=2){
            return s;
        }
        final Map<Character, Integer> freq = s.chars().
                mapToObj(item -> (char) item).collect(Collectors.toMap(Function.identity(),
                v -> 1,
                (v1, v2) -> ++v1));

        final String collect = freq.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(value -> {
                    if (value.getValue() == 1) {
                        return "" + value.getKey();
                    } else {
                        return String.join("", Collections.nCopies(value.getValue(), "" + value.getKey()));
                    }
                })
                .collect(Collectors.joining());

        return collect;

    }


    public String frequencySortWithPriority(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int)e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}
