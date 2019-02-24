package com.example.alg.stringpck;

public class UniqueStrings {

    public boolean isUniqueChars(String text){
        if(text.length()>128){
            return false;
        }

        boolean[] charactersFound = new boolean[128];
        for (int i = 0; i < text.length(); i++) {
            final char character = text.charAt(i);
            if(charactersFound[character]){
                return false;
            }
            charactersFound[character]=true;
        }
        return true;
    }

    /**
     * 828
     * A character is unique in string S if it occurs exactly once in it.
     *
     * For example, in string S = "LETTER", the only unique characters are "L" and "R".
     *
     * Let's define UNIQ(S) as the number of unique characters in string S.
     *
     * For example, UNIQ("LETTER") =  2.
     *
     * Given a string S with only uppercases, calculate the sum of UNIQ(substring) over all non-empty substrings of S.
     *
     * If there are two or more equal substrings at different positions in S, we consider them different.
     *
     * Since the answer can be very large, return the answer modulo 10 ^ 9 + 7.
     */
    public int uniqueLetterString(String S) {

        int res = 0;
        if (S == null || S.length() == 0)
            return res;
        int[] showLastPosition = new int[128];
        int[] contribution = new int[128];
        int cur = 0;
        for (int i = 0; i < S.length(); i++) {
            char x = S.charAt(i);
            cur -= contribution[x];
            contribution[x] = (i - (showLastPosition[x] - 1));
            cur += contribution[x];
            showLastPosition[x] = i + 1;
            res += cur;
        }
        return res;

    }


}
