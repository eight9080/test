package com.example.alg.arraypkg;

import java.util.List;
import java.util.stream.Collectors;

public class Triangle {

    /**
     * Given a triangle, find the minimum path sum from top to bottom.
     * Each step you may move to adjacent numbers on the row below.

     For example, given the following triangle
     [
     [2],
     [3,4],
     [6,5,7],
     [4,1,8,3]
     ]
     The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.isEmpty()){
            return 0;
        }

        final List<Integer> lastRow = triangle.get(triangle.size()-1);
        final List<Integer> totalPath = lastRow.stream().collect(Collectors.toList());

        for(int i = triangle.size()-2 ; i>=0; i--){
            final List<Integer> row = triangle.get(i);
            for(int j = 0; j< triangle.get(i+1).size()-1; j++){
                totalPath.set(j, row.get(j)+Math.min(totalPath.get(j), totalPath.get(j+1)));
            }

        }
        return totalPath.get(0);

    }
}
