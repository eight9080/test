package com.example.alg.arraypkg;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        final Map<Integer, Integer> frequencyMap = Arrays.stream(nums).boxed().collect(
                Collectors.toMap(a -> a, a -> 1, (a, b) -> ++a));

        List<Integer>[] buckets = new List[nums.length + 1];

        for (int key : frequencyMap.keySet()) {
            final Integer frequency = frequencyMap.get(key);

            if(buckets[frequency]==null){
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        final ArrayList<Integer> result = new ArrayList<>();

        for(int i = buckets.length-1; i >=0; i--){
            if(result.size()<=k) {
                final List<Integer> elements = buckets[i];
                if(elements!=null && !elements.isEmpty()) {
                    if(elements.size()+result.size()<=k) {
                        result.addAll(elements);
                    }else{
                        final int necessaryElements = k - result.size();
                        result.addAll(elements.stream().limit(necessaryElements).collect(Collectors.toList()));
                    }
                }
            }
        }

            return result;
    }
}
