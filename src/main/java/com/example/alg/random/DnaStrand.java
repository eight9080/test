package com.example.alg.random;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DnaStrand {


    public static String makeComplement(String dna) {
        Map<Character, String> dnaMapping = new HashMap<>();
        dnaMapping.put('A', "T");
        dnaMapping.put('T', "A");
        dnaMapping.put('C', "G");
        dnaMapping.put('G', "C");
        final String result = dna.chars()
                .mapToObj(c -> dnaMapping.get((char)c))
                .map(String::valueOf)
                .collect(Collectors.joining());

        return result;

    }
}
