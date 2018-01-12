package com.example.alg.permutations;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    /**
     * Numbers can be regarded as product of its factors. For example,

     8 = 2 x 2 x 2;
     = 2 x 4.
     Write a function that takes an integer n and return all possible combinations of its factors.

     */
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(2, 1, n, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int num, int product, int n, List<Integer> current, List<List<Integer>> result) {
        if(num>n || product>n){
            return;
        }

        if(product==n){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = num; i<n; i++){
            if(i*product>n)
                break;

            if(n%i==0) {
                current.add(i);
                dfs(i, i * product, n, current, result);
                current.remove(current.size()-1);
            }
        }


    }
}
