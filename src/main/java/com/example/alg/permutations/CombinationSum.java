package com.example.alg.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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


    /**
     * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

     Each number in C may only be used once in the combination.

     Note:
     All numbers (including target) will be positive integers.
     The solution set must not contain duplicate combinations.
     For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
     A solution set is:
     [
     [1, 7],
     [1, 2, 5],
     [2, 6],
     [1, 1, 6]
     ]
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0)
            return Collections.emptyList();

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        helperCombSum2(candidates, target, 0, new ArrayList<>(), res);

        return res;
    }

    private void helperCombSum2(int[] candidates, int target, int index,
                                List<Integer> current, List<List<Integer>> res) {
        if(target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            if(target<candidates[i])
                return;

            if(i > index && candidates[i-1]==candidates[i]) continue;

            current.add(candidates[i]);
            helperCombSum2(candidates, target-candidates[i], i+1, current, res);
            current.remove(current.size()-1);
        }

    }

    /**
     * Find all possible combinations of k numbers that add up to a number n,
     * given that only numbers from 1 to 9 can be used and each combination should be a unique
     * set of numbers.


     Example 1:

     Input: k = 3, n = 7

     Output:

     [[1,2,4]]

     Example 2:

     Input: k = 3, n = 9

     Output:

     [[1,2,6], [1,3,5], [2,3,4]]
     */
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<>();

        final List<Integer> numbers = IntStream.rangeClosed(1, 9).boxed().collect(Collectors.toList());

        helperCombSum3(numbers, n, k, 0, new ArrayList<>(), res);

        return res;
    }

    private void helperCombSum3(List<Integer> candidates, int target, int maxNumbers, int index,
                                List<Integer> current, List<List<Integer>> res) {
        if (target < 0 || current.size() > maxNumbers) {
            return;
        }
        if (target == 0 && current.size()==maxNumbers) {
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < candidates.size(); i++) {

            if (target < candidates.get(i))
                return;

            if (i > index && candidates.get(i - 1).equals(candidates.get(i))) continue;

            current.add(candidates.get(i));
            helperCombSum3(candidates, target - candidates.get(i), maxNumbers, i + 1, current, res);
            current.remove(current.size() - 1);
        }
    }

}
