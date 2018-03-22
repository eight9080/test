package com.example.alg.arraypkg;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {

    /**
     * Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

     For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73],
     your output should be [1, 1, 4, 2, 1, 1, 0, 0].
     */
    public int[] dailyTemperatures(int[] temperatures) {
        final int[] diffDays = new int[temperatures.length];

        final Deque<Integer> positions = new ArrayDeque<>();

        positions.push(0);

        for (int i = 1; i < temperatures.length; i++) {

            if(positions.isEmpty()){
                continue;
            }

            while (!positions.isEmpty() && temperatures[positions.peek()]<temperatures[i]){
                final Integer initialDay = positions.pop();
                final int diffDaysNo = i - initialDay;
                diffDays[initialDay]=diffDaysNo;
            }
            positions.push(i);
        }

        positions.forEach(i-> diffDays[i]=0);

        return diffDays;

    }

}
