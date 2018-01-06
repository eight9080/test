package com.example.alg.permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    /**
     * Given a collection of distinct numbers, return all possible permutations.

     For example,
     [1,2,3] have the following permutations:
     [
     [1,2,3],
     [1,3,2],
     [2,1,3],
     [2,3,1],
     [3,1,2],
     [3,2,1]
     ]
     */
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        res.add(new ArrayList<>());

        for (int n : nums) {

            int size = res.size();
            while (size>0){
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
}
