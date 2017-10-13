package com.example.alg.arraypkg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PascalTriangle {


    /**
     * Given numRows, generate the first numRows of Pascal's triangle. For example, given numRows = 5,
     * the result should be:
     [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
     ]
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0)
            return result;
        result.add(Collections.singletonList(1));
        int i = 1;
        while (i<numRows){
            final List<Integer> newList = new ArrayList<>();
            newList.add(1);

            final List<Integer> prevList = result.get(i - 1);
            for (int j = 0; j< prevList.size()-1; j++) {
                newList.add(prevList.get(j)+prevList.get(j+1));
            }
            newList.add(1);
            result.add(newList);
            i++;
        }

        return result;
    }

    /**
     * Given an index k, return the kth row of the Pascal's triangle.

     For example, given k = 3,
     Return [1,3,3,1].
     */
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex<0) return null;

        final List<Integer> result = new ArrayList<>();
        result.add(1);
        if(rowIndex==0) return result;
        for(int i=0; i< rowIndex; i++){
            for(int j = result.size()-2; j>=0; j--){
                result.set(j+1,result.get(j)+result.get(j+1));
            }
            result.add(1);
        }

        return result;
    }

}
