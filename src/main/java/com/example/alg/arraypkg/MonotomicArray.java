package com.example.alg.arraypkg;

import java.util.function.BiFunction;

public class MonotomicArray {

    /**
     * An array is monotonic if it is either monotone increasing or monotone decreasing.
     *
     * An array A is monotone increasing if for all i <= j, A[i] <= A[j]. An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
     *
     * Return true if and only if the given array A is monotonic.
     *
     *
     *
     * Example 1:
     *
     * Input: [1,2,2,3]
     * Output: true
     * Example 2:
     *
     * Input: [6,5,4,4]
     * Output: true
     * Example 3:
     *
     * Input: [1,3,2]
     * Output: false
     * Example 4:
     *
     * Input: [1,2,4,5]
     * Output: true
     * Example 5:
     *
     * Input: [1,1,1]
     * Output: true
     */
    public boolean isMonotonic(int[] A) {

        BiFunction<Integer, Integer, Boolean> fDesc = (a, b) -> a<=b;
        BiFunction<Integer, Integer, Boolean> fAsc = (a, b) -> a>=b;

        BiFunction<Integer, Integer, Boolean> fType = null;
        for (int i = 0; i < A.length-1; i++) {
            if(fType==null){
                if(A[i]==A[i+1]){
                    continue;
                }
                fType = A[i]<A[i+1]?fDesc:fAsc;
            }
            if(!fType.apply(A[i], A[i+1])){
                return false;
            }
        }

        return true;
    }
}
