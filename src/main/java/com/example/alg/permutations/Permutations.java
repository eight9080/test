package com.example.alg.permutations;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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


    public List<List<Integer>> permuteBackTracking(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrackPermute(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrackPermute(List<List<Integer>> list, List<Integer> tempList, int[] nums) {

        if(tempList.size()==nums.length){
            list.add(new ArrayList<>(tempList));
            return;
        }

        for (int num : nums) {
            if(tempList.contains(num)){
                continue;
            }
            tempList.add(num);
            backtrackPermute(list, tempList, nums);
            tempList.remove(tempList.size()-1);
        }

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

    /**
     * The set [1,2,3,…,n] contains a total of n! unique permutations.

     By listing and labeling all of the permutations in order,
     We get the following sequence (ie, for n = 3):

     "123"
     "132"
     "213"
     "231"
     "312"
     "321"
     Given n and k, return the kth permutation sequence.

     Note: Given n will be between 1 and 9 inclusive.
     */
    public String getPermutation(int n, int k) {

        int[] factorial = new int[n+1];

        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for(int i=1; i<=n; i++){
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        // create a list of numbers to get indices
        final List<Integer> numbers = IntStream.rangeClosed(1, n)
                .boxed().collect(Collectors.toList());
        // numbers = {1, 2, 3, 4}

        k--;

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++){
            int index = k/factorial[n-i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k-=index*factorial[n-i];
        }

        return sb.toString();


    }

}
