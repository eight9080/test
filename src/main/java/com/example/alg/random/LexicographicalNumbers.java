package com.example.alg.random;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {

    /**
     * Given an integer n, return 1 - n in lexicographical order.
     *
     * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
     *
     * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
     */
    public List<Integer> lexicalOrder(int n) {

        List<Integer> result = new ArrayList<>();

        dfs(1, 9, n, result);
        return result;
    }

    private void dfs(int start, int end, int n, List<Integer> result) {
        for (int i = start; i <= end && i <= n; i++) {
            result.add(i);
            // 10 -> next recursion: 100(->next recursion 1000), 101,102....
            // next loop: 11 -> next recursion: 110,  111,112....
            // next loop: 12 -> next recursion: 120,  121,122....
            dfs(i* 10, i*10+9, n, result);


        }
    }

}
