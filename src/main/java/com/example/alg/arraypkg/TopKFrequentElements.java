package com.example.alg.arraypkg;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        final Map<Integer, Integer> frequencyMap = Arrays.stream(nums).boxed().collect(
                Collectors.toMap(a -> a, a -> 1, (a, b) -> ++a));

        List<Integer>[] buckets = new List[nums.length + 1];

        for (int key : frequencyMap.keySet()) {
            final Integer frequency = frequencyMap.get(key);

            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        final ArrayList<Integer> result = new ArrayList<>();

        for (int i = buckets.length - 1; i >= 0; i--) {
            if (result.size() <= k) {
                final List<Integer> elements = buckets[i];
                if (elements != null && !elements.isEmpty()) {
                    if (elements.size() + result.size() <= k) {
                        result.addAll(elements);
                    } else {
                        final int necessaryElements = k - result.size();
                        result.addAll(elements.stream().limit(necessaryElements).collect(Collectors.toList()));
                    }
                }
            }
        }

        return result;
    }

    /**
     * Given a non-empty list of words, return the k most frequent elements.
     * <p>
     * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
     * <p>
     * Example 1:
     * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
     * Output: ["i", "love"]
     * Explanation: "i" and "love" are the two most frequent words.
     * Note that "i" comes before "love" due to a lower alphabetical order.
     * Example 2:
     * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
     * Output: ["the", "is", "sunny", "day"]
     * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
     * with the number of occurrence being 4, 3, 2 and 1 respectively.
     */
    public List<String> topKFrequent(String[] words, int k) {

        final Map<String, Integer> freq = Arrays.stream(words)
                .collect(Collectors.toMap(Function.identity(), w -> 1, (a, b) -> a + 1));
        final List<String> result = freq.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(k)
                .map(v -> v.getKey())
                .collect(Collectors.toList());

        return result;


//        final PriorityQueue<String> wordsResult = new PriorityQueueiorityQueue<>();


    }
}
