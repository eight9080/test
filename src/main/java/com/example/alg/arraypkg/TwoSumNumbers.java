package com.example.alg.arraypkg;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.

 add - Add the number to an internal data structure.
 find - Find if there exists any pair of numbers which sum is equal to the value.

 For example,

 add(1);
 add(3);
 add(5);
 find(4) -> true
 find(7) -> false

 */
public class TwoSumNumbers {

    private Map<Integer, Integer> numbersByOccurances = new HashMap<>();

    public void add(int number){
        numbersByOccurances.compute(number, (k,v) -> v==null? 1: v+1);
    }

    public boolean find (int value){
        for(Integer i: numbersByOccurances.keySet()){
            int target = value - i;
            if(numbersByOccurances.containsKey(target)){
                if(i==target && numbersByOccurances.get(target)<2){
                    continue;
                }
                return true;
            }
        }
        return false;
    }


}
