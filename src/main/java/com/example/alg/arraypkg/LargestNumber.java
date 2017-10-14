package com.example.alg.arraypkg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class LargestNumber {
    /**
     * Given a list of non negative integers, arrange them such that they form the largest number.

     For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
     (Note: The result may be very large, so you need to return a string instead of an integer.
     */
    public String largestNumber(int[] nums) {
         String numberStr = Arrays.stream(nums).boxed()
                .map(Object::toString)
                .sorted((a,b)-> (b+a).compareTo(a+b))
                .reduce("", (a, b) -> a + b);

        while(numberStr.charAt(0)=='0'&&numberStr.length()>1)
            numberStr = numberStr.substring(1);
        return numberStr;
    }

}
