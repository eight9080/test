package com.example.alg.stringpck;

public class Conversion {
    /**
     * Implement atoi to convert a string to an integer.
     * <p>
     * 1. null or empty string
     * 2. white spaces
     * 3. +/- sign
     * 4. calculate real value
     * 5. handle min & max
     */
    public static int atoi(String str) {
        if (str == null || str.length() < 1)
            return 0;

        // trim white spaces
        str = str.trim();

        char flag = '+';

        //check negative to store result
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }

        double result = 0;
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (flag == '-') {
            result = -result;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;

    }

    /**
     * The count-and-say sequence is the sequence of integers beginning as follows:
     * 1, 11, 21, 1211, 111221, ...
     * <p>
     * 1 is read off as "one 1" or 11.
     * 11 is read off as "two 1s" or 21.
     * 21 is read off as "one 2, then one 1" or 1211.
     */
    public String countAndSay(int n) {
        if (n <= 0)
            return null;

        String result = "";
        final String sNum = String.valueOf(n);
        final char[] chars = sNum.toCharArray();

        Character currentChar = null;
        int count = 0;
        for (char c : chars) {
            if (currentChar == null || currentChar == c) {
                currentChar = c;
                count++;
            } else {
                result += count + "" + currentChar;
                currentChar = c;
                count = 1;
            }
        }
        if (currentChar != null) {
            result += count + "" + currentChar;
        }


        return result;
    }

    public String countAndSay2(int n) {
        if (n <= 0)
            return null;

        String result = "1";
        int i = 1;

        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }

            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            System.out.println("Temp: "+sb.toString());
            i++;
        }

        return result;
    }
}
