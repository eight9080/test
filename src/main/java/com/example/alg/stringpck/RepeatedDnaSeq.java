package com.example.alg.stringpck;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

 Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 For example,

 Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

 Return:
 ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class RepeatedDnaSeq {

    public List<String> findRepeatedDnaSequences(String s) {

        final HashSet<String> result = new HashSet<>();
        final HashSet<Object> seen = new HashSet<>();

        for (int i = 0; i+9 < s.length(); i++) {
            final String seq = s.substring(i, i + 10);
            if(!seen.add(seq)){
                result.add(seq);
            }
        }
        return new ArrayList<>(result);
    }
}
