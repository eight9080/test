package com.example.alg.permutations;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

     For example, given n = 3, a solution set is:

     [
     "((()))",
     "(()())",
     "(())()",
     "()(())",
     "()()()"
     ]
     */
    /*
    left and right represents the remaining number of ( and ) that need to be added.
    When left > right, there are more ")" placed than "(". Such cases are wrong and the method stops.
    */
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        dfs(result, "", n, n);
        return result;
    }

    public void dfs(List<String> result, String s, int left, int right){
        if(left > right)
            return;

        if(left==0 && right==0){
            result.add(s);
            return;
        }

        if(left>0){
            dfs(result, s+"(", left-1, right);
        }

        if(right>0){
            dfs(result, s+")", left, right-1);
        }
    }
}
