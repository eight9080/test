package com.example.alg.stringpck;

public class OneEditDistance {

    /**
     * Given two strings S and T, determine if they are both one edit distance apart.
     */
    public static boolean isOneEditDistance(String s, String t) {
        if(s==null || t==null){
            return false;
        }
        int sLength = s.length();
        int tLength = t.length();

        if(Math.abs(sLength-tLength)>1){
            return false;
        }

        int sIndex = 0;
        int tIndex = 0;
        int countMoves = 0;

        while (sIndex<sLength && tIndex< tLength){

            if(s.charAt(sIndex)==t.charAt(tIndex)){
                sIndex++;
                tIndex++;
            }else{
                countMoves++;
                if(countMoves>1){
                    return false;
                }

                if(sLength>tLength){
                    sIndex++;
                }else if(sLength<tLength){
                    tIndex++;
                }else {
                    sIndex++;
                    tIndex++;
                }
            }
        }

        if(sIndex<sLength || tIndex< tLength){
            countMoves++;
        }
        if(countMoves==1){
            return true;
        }

        return false;
    }
}
