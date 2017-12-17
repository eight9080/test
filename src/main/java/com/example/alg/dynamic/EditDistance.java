package com.example.alg.dynamic;

public class EditDistance {
    /**
     * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

     You have the following 3 operations permitted on a word:

     a) Insert a character
     b) Delete a character
     c) Replace a character
     */
    public int minDistance(String word1, String word2) {

        int len1 = word1.length();
        int len2 = word2.length();

        // len1+1, len2+1, because finally return distance[len1][len2]
        int[][] distance = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            distance[i][0] = i;
        }

        for (int j = 0; j <= len2; j++) {
            distance[0][j] = j;
        }

        for(int i=1;i <=len1; i++) {
            final char charA = word1.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                final char charB = word2.charAt(j - 1);
                if(charA==charB){
                    distance[i][j]=distance[i-1][j-1];
                }else {
                    distance[i][j] = 1+ Math.min(
                            Math.min(distance[i-1][j-1], distance[i-1][j]),
                            distance[i][j-1]);
                }
            }
        }

        return distance[len1][len2];

    }

    public int recEditDistance(char[]  str1, char str2[], int len1,int len2){

        if(len1 == str1.length){
            return str2.length - len2;
        }
        if(len2 == str2.length){
            return str1.length - len1;
        }
        return min(recEditDistance(str1, str2, len1 + 1, len2 + 1)
                + str1[len1] == str2[len2] ? 0 : 1,
                recEditDistance(str1, str2, len1,len2 + 1) + 1,
                recEditDistance(str1, str2, len1 + 1, len2) + 1);
    }

    private int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }

}
