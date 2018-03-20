package com.example.alg.stringpck;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JewelsStones {
    /**
     * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

     The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

     Example 1:

     Input: J = "aA", S = "aAAbbbb"
     Output: 3
     Example 2:

     Input: J = "z", S = "ZZ"
     Output: 0
     */
    public int numJewelsInStones(String J, String S) {

        final Map<Character, Character> jewels = J.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(Function.identity(), Function.identity()));

        return (int)S.chars()
                .mapToObj(c-> (char)c)
                .filter(c-> jewels.containsKey(c))
                .count();

    }
}
