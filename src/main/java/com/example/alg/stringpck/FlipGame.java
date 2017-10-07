package com.example.alg.stringpck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlipGame {

    /**
     * You are playing the following Flip Game with your friend: Given a string that contains only these
     * two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--".
     * The game ends when a person can no longer make a move and therefore the other person will be the winner.
     Write a function to compute all possible states of the string after one valid move.
     For example, given s = "++++", after one move, it may become one of the following states:
     [
     "--++",
     "+--+",
     "++--"
     ]
     please notice that the input string may be all '+', or all '-', or somewhere in between.
     */
    public static List<String> generatePossibleNextMoves(String s) {
        if(s==null || s.length()<2){
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        final char[] chars = s.toCharArray();
        for(int i = 0; i< chars.length-1; i++){
                if(chars[i]=='+' && chars[i+1]=='+'){
                    chars[i]='-';
                    chars[i+1] ='-';
                    result.add(new String(chars));
                    chars[i]='+';
                    chars[i+1] ='+';
                }
        }

        return result;
    }
}
