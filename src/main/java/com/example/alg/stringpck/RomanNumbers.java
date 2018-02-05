package com.example.alg.stringpck;

import java.util.HashMap;
import java.util.Map;

public class RomanNumbers {
    /**
     * Given a roman numeral, convert it to an integer.
     * <p>
     * Input is guaranteed to be within the range from 1 to 3999.
     */
    public int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        if (s == null || s.length() == 0) {
            return 0;
        }

        int number = 0;
        for (int i = 0; i < s.length(); ) {

            final char digit = s.charAt(i);
            final Integer currentNumber = map.get(digit);

            if (i + 1 < s.length()) {
                final Integer nextNumber = map.get(s.charAt(i + 1));
                if (currentNumber < nextNumber) {
                    number += (nextNumber - currentNumber);
                    i = i + 2;
                    continue;
                }
            }
            number += currentNumber;
            i++;

        }
        return number;
    }
}
