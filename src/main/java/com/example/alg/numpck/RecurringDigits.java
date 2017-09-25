package com.example.alg.numpck;

public class RecurringDigits {

    /**
     * Remove recurring digits in a given number
     Given a number as string, remove recurring digits from the given string. The changes must be made in-place. Expected time complexity O(n) and auxiliary space O(1).

     Examples:

     Input:  num[] = "1299888833"
     Output: num[] = "12983"

     Input:  num[] = "1299888833222"
     Output: num[] = "129832"
     */
    public static long removeRecurringDigits(long num){
        final char[] chars = Long.toString(num).toCharArray();
        int len = chars.length;
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<len; i++){
            result.append(chars[i]);
            while (i+1<len && chars[i]==chars[i+1]){
                i++;
            }

        }
        return Long.valueOf(result.toString());
    }

}
