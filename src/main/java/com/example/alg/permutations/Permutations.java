package com.example.alg.permutations;

import java.util.*;

public class Permutations {
    /**
     * Given a collection of distinct numbers, return all possible permutations.
     * <p>
     * For example,
     * [1,2,3] have the following permutations:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     */
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        res.add(new ArrayList<>());

        for (int n : nums) {

            int size = res.size();
            while (size > 0) {
                List<Integer> prevPerm = res.poll();
                for (int i = 0; i <= prevPerm.size(); i++) {
                    List<Integer> newPerm = new ArrayList<>(prevPerm);
                    newPerm.add(i, n); //add at new position
                    res.add(newPerm);
                }
                size--;
            }

        }
        return res;
    }

    /**
     * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
     * <p>
     * For example,
     * [1,1,2] have the following unique permutations:
     * [
     * [1,1,2],
     * [1,2,1],
     * [2,1,1]
     * ]
     */
    public List<List<Integer>> permuteUnique(int[] nums) {

        LinkedList<List<Integer>> res = new LinkedList<>();
        res.add(new ArrayList<>());

        for (int n : nums) {

            Set<List<Integer>> cache = new HashSet<>();
            while (!res.isEmpty()) {
                List<Integer> prevPerm = res.poll();
                for (int i = 0; i <= prevPerm.size(); i++) {
                    List<Integer> newPerm = new ArrayList<>(prevPerm);
                    newPerm.add(i, n); //add at new position
                    System.out.println("NewPerm" + newPerm);
                    cache.add(newPerm);
                    System.out.println("cache" + cache);
                }
            }
            res.addAll(cache);
            System.out.println("res" + res);
        }

        return res;

    }

}
