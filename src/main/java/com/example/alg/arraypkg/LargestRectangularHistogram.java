package com.example.alg.arraypkg;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LargestRectangularHistogram {
    /**
     * Given n non-negative integers representing
     * the histogram's bar heights where the width of each bar is 1,
     * find the area of largest rectangle in the histogram.
     * For example, given heights = [2,1,5,6,2,3], return 10.
     * The key to solve this problem is to maintain a stack to store bars' indexes.
     * The stack only keeps the increasing bars.
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int maxArea=0;
        int i = 0;

        Deque<Integer> barPositions = new ArrayDeque<>();
        while( i <= heights.length){
            int val = i < heights.length ? heights[i] : 0;
            if(barPositions.isEmpty() || val>=heights[barPositions.peek()]){
                barPositions.push(i);
                i++;
            }else{
                final Integer rightBarIndex = barPositions.pop();
                final Integer width = !barPositions.isEmpty() ? i-barPositions.peek()-1 : i;
                final int currentArea = width * heights[rightBarIndex];
                maxArea = Math.max(maxArea, currentArea);

            }
        }
        return maxArea;
    }

    public int largestRectangleArea1(int[] heights) {
        Stack<Integer> stack = new Stack<>();// stack for index to calculate width.
        int max = 0;
        int i =0;
        while( i <= heights.length){
            int val = i < heights.length ? heights[i] : 0;
            if(stack.empty() || val >= heights[stack.peek()]){
                stack.push(i);
                i++;
            }else{
                int h = stack.pop();
                int w = stack.empty() ? i : i - stack.peek() -1;
                max = Math.max(max, heights[h] * w);
            }
        }

        return max;
    }

}
