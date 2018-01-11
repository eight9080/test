package com.example.alg.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Combinations {
    /**
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
     * <p>
     * For example,
     * If n = 4 and k = 2, a solution is:
     * <p>
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     */
    public List<List<Integer>> combine(int n, int k) {

        if (n <= 0 || n < k)
            return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();

        dfs(n, k, 1, new ArrayList<>(), result);

        return result;
    }

    private void dfs(int n, int k, int start,
                                 List<Integer> current,
                                 List<List<Integer>> res) {
        if (current.size() == k) {
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            dfs(n, k, i + 1, current, res);
            current.remove(current.size() - 1);
        }
    }
}
