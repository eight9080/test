package com.example.alg.arraypkg;

import java.util.ArrayList;
import java.util.List;

public class GetTarget {

    /**
     * Get Target Number Using Number List and Arithmetic Operations
     * Given a list of numbers and a target number, write a program to determine whether the
     * target number can be calculated by applying +-* / operations to the number list?
     * You can assume is automatically added when necessary.
     * For example, given {1,2,3,4} and 21, return true. Because (1+2)*(3+4)=21
     */
    public static boolean isReachable(List<Integer> list, int target) {
        if (list == null || list.size() == 0)
            return false;

        int i = 0;
        int j = list.size() - 1;

        ArrayList<Integer> results = getPosibleComputations(list, i, j);
        return results.stream().map(result-> result==target).filter(r -> r).findFirst().orElse(false);
    }

    private static ArrayList<Integer> getPosibleComputations(List<Integer> list, int left, int right) {
        ArrayList<Integer> result = new ArrayList<>();

        if (left > right) {
            return result;
        } else if (left == right) {
            result.add(list.get(left));
            return result;
        }

        for (int i = left; i < right; i++) {
            final ArrayList<Integer> resultFirstPart = getPosibleComputations(list, left, i);
            final ArrayList<Integer> resultSecondPart = getPosibleComputations(list, i+1, right);

            for(int r1: resultFirstPart){
                for (int r2: resultSecondPart){
                    result.add(r1+r2);
                    result.add(r1-r2);
                    result.add(r1*r2);
                    if(r2!=0){
                        result.add(r1/r2);
                    }
                }
            }
        }
            return result;
    }
}
