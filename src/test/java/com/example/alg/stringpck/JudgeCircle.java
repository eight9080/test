package com.example.alg.stringpck;


/**
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
 *
 * The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
 *
 * Example 1:
 * Input: "UD"
 * Output: true
 * Example 2:
 * Input: "LL"
 * Output: false
 */
public class JudgeCircle {

    public boolean judgeCircle(String moves) {

        int vertical=0;
        int horizontal=0;

        for (char c : moves.toCharArray()) {

            if(c=='D'){
                vertical--;
            }else if (c=='U'){
                vertical++;
            }else if(c=='L'){
                horizontal--;
            }else if(c=='R'){
                horizontal++;
            }

        }
        return vertical==0 && horizontal==0;
    }

}
