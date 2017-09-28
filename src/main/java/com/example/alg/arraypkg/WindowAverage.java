package com.example.alg.arraypkg;

import java.math.BigDecimal;
import java.util.LinkedList;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 */
public class WindowAverage {

    private LinkedList<Integer> windowOfNumbers;
    private int windowSize;
    private long sumOfWindow = 0;

    public WindowAverage(int windowSize) {
        this.windowSize = windowSize;
        this.windowOfNumbers = new LinkedList<>();
    }

    /**
     *
     * @param val next value from the data stream
     * @return average of window numbers
     */
    public BigDecimal next(int val){

        if(this.windowOfNumbers.size()<this.windowSize){
            //add element
            this.windowOfNumbers.offer(val);
            this.sumOfWindow+=val;
        }else{
            final Integer head = this.windowOfNumbers.poll();
            this.sumOfWindow-=head;
            this.windowOfNumbers.offer(val);
            this.sumOfWindow+=val;
        }

        return BigDecimal.valueOf(this.sumOfWindow)
                .divide(BigDecimal.valueOf(this.windowOfNumbers.size()),1, BigDecimal.ROUND_HALF_UP);
    }

}
