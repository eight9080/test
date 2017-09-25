package com.example.alg;

import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AlgArray {
    
    private String[] array;

    public AlgArray(String[] array) {
        this.array = array;
    }

    public String[] getArray() {
        return array;
    }
    
    public HashSet<String> findDuplicates(){
        final HashSet<String> store = new HashSet<>();
        final HashSet<String> duplicates = new HashSet<>();
        for (String s: array) {
            if(!store.add(s)){
                duplicates.add(s);
            }
        }
        return duplicates;
    }

    public Map<String, Integer> findNoOfOccuranceOfDuplicates(){
        final Map<String, Integer> occurences = Stream.of(array).collect(Collectors.toMap(sKey -> sKey,
                sValue -> 1, (p1, p2) -> ++p1));
        occurences.entrySet().removeIf(e -> e.getValue()<=1);
        return occurences;
    }

}