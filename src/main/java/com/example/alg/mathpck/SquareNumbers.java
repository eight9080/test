package com.example.alg.mathpck;

public class SquareNumbers {
    /**
     * Given a non-negative integer c, your task is to decide whether
     * there're two integers a and b such that a2 + b2 = c.

     Example 1:
     Input: 5
     Output: True
     Explanation: 1 * 1 + 2 * 2 = 5
     Example 2:
     Input: 3
     Output: False
     */
    public boolean judgeSquareSum(int c) {

        if(c<0){
            return false;
        }

        int start = 0;
        int end = (int)Math.sqrt(c);

        while (start<=end){
            int number = start*start+end*end;
            if(number==c){
                return true;
            }

            if(number<c){
                start++;
            }else {
                end--;
            }
        }

        return false;

    }
}
