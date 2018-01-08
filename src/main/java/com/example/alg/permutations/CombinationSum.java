package com.example.alg.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    /**
     * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

     The same repeated number may be chosen from C unlimited number of times.

     Note:
     All numbers (including target) will be positive integers.
     The solution set must not contain duplicate combinations.
     For example, given candidate set [2, 3, 6, 7] and target 7,
     A solution set is:
     [
     [7],
     [2, 2, 3]
     ]
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if(candidates == null || candidates.length == 0)
            return Collections.emptyList();

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        helperCombSum(candidates, target, 0, new ArrayList<>(), res);

        return res;

    }

    private void helperCombSum(int[] candidates, int target, int index,
                               List<Integer> current, List<List<Integer>> res) {

        if(target<=0){
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            if(target<candidates[i])
                return;

            current.add(candidates[i]);
            helperCombSum(candidates, target-candidates[i], i, current, res);
            current.remove(current.size()-1);
        }


    }
}
