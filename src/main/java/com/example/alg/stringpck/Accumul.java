package com.example.alg.stringpck;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Accumul {

    /**
     * accum("abcd") -> "A-Bb-Ccc-Dddd"
     * accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
     * accum("cwAt") -> "C-Ww-Aaa-Tttt"
     */
    public static String accum(String s) {

        StringBuilder result = new StringBuilder();
        final char[] chars = s.toCharArray();
        result.append(Character.toUpperCase(chars[0]));
        for (int i = 1; i < chars.length; i++) {
            result.append("-")
                    .append(Character.toUpperCase(chars[i]));

            String character = Character.toString(chars[i]).toLowerCase();
            final String repeat = IntStream.range(0, i).mapToObj(c -> character)
                    .collect(Collectors.joining(""));
            result.append(repeat);
        }

        // your code
        return result.toString();
    }
}
