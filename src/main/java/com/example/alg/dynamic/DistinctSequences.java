package com.example.alg.dynamic;

public class DistinctSequences {
    /**
     * Given a string S and a string T, count the number of distinct subsequences of S which equals T.

     A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

     Here is an example:
     S = "rabbbit", T = "rabbit"

     Return 3.
     */
    public int numDistinct(String s, String t) {

        if(s==null || t==null){
            return 0;
        }

        if (s.length() == 0 || t.length() == 0) {
            return 0;
        }

        int[][] temp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i < temp[0].length; i++) {
            temp[0][i] = 1;
        }

        for (int i = 1; i < temp.length; i++) {
            final char characterT = t.charAt(i - 1);
            for (int j = 1; j < temp[0].length; j++) {
                final char characterS = s.charAt(j - 1);
                if(characterS==characterT){
                    temp[i][j]=temp[i-1][j-1]+temp[i][j-1];
                }else {
                    temp[i][j]=temp[i][j-1];
                }
            }
        }

        return temp[t.length()][s.length()];
    }
}
