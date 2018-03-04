package com.example.alg.mathpck;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Multiples {

    /**
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
     * The sum of these multiples is 23.

     Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.

     Note: If the number is a multiple of both 3 and 5, only count it once.
     */
    public int solution(int number) {

        Set<Integer> selectedNumbers = new HashSet<>();
        List<Integer> multiples = new ArrayList<>();
        multiples.add(3);
        multiples.add(5);

        int i = 1;
        List<Integer> removedMultiples = new ArrayList<>();
        while (!multiples.isEmpty()){
            for (Integer multiple : multiples) {
                final int candidateNumber = multiple * i;
                if(candidateNumber<number){
                    selectedNumbers.add(candidateNumber);
                }else {
                    removedMultiples.add(multiple);
                }
            }
            if(!removedMultiples.isEmpty()) {
                multiples.removeAll(removedMultiples);
                removedMultiples.clear();
            }
            i++;
        }

        return selectedNumbers.stream().reduce(0, (a,b) -> a+b);

    }
}
