package com.example.alg.greedypkg;

import java.util.Arrays;

public class BagTokens {

    /**
     * 948
     * You have an initial power P, an initial score of 0 points, and a bag of tokens.
     *
     * Each token can be used at most once, has a value token[i], and has potentially two ways to use it.
     *
     * If we have at least token[i] power, we may play the token face up, losing token[i] power, and gaining 1 point.
     * If we have at least 1 point, we may play the token face down, gaining token[i] power, and losing 1 point.
     * Return the largest number of points we can have after playing any number of tokens.
     */
    public int bagOfTokensScore(int[] tokens, int P) {

        Arrays.sort(tokens);

        int result = 0;

        int points  = 0;
        int power = P;
        int i=0;
        int j= tokens.length-1;

        while (i<=j){
            //have power to take point
            if(power>=tokens[i]){
                power-= tokens[i++];
                result = Math.max(result, ++points);
            }else if(points>0){
                points--;
                power+=tokens[j--];
            }else {
                break;
            }

        }


        return result;

    }
}
