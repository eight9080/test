package com.example.alg.mathpck;

import java.util.HashMap;
import java.util.Map;

public class Fraction {

    /**
     * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

     If the fractional part is repeating, enclose the repeating part in parentheses.

     For example,

     Given numerator = 1, denominator = 2, return "0.5".
     Given numerator = 2, denominator = 1, return "2".
     Given numerator = 2, denominator = 3, return "0.(6)".
     */
    public String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0)
            return "0";
        if (denominator == 0)
            return "";

        String result = "";
        
        if(numerator<0 ^ denominator<0){
            result+="-";
        }

        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        //integral part
        final long resultInt = (num / den);
        result+=resultInt;


        long remainder = (num % den) *10;

        if(remainder==0){
            return result;
        }

        //fractional part
        result+=".";
        Map<Long, Integer> map = new HashMap<>();
        long fractionalPart = 0;
        while (remainder!=0){

            if(map.containsKey(remainder)){
                final Integer size = map.get(remainder);
                final String part1 = result.substring(0, size);
                final String part2 = result.substring(size, result.length());
                return part1+"("+part2+")";
            }

            map.put(remainder, result.length());
            fractionalPart=remainder/den;
            result+=fractionalPart;
            remainder=(remainder%denominator)*10;
        }
        return result;
    }

}
