package com.example.alg.arraypkg;

public class TrappingRainWater {

    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1,
     * compute how much water it is able to trap after raining.

     For example,
     Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
     */
    public int trap(int[] height) {
        int gaps = 0;

        if (height == null || height.length <= 2)
            return gaps;

        int[] leftWalls = new int[height.length];
        int[] rightWalls = new int[height.length];

        for(int i = 1; i<height.length; i++){
            leftWalls[i] = Math.max(leftWalls[i-1], height[i-1]);
        }

        for(int i = height.length-2; i>=0; i--){
            rightWalls[i] = Math.max(rightWalls[i+1], height[i+1]);
        }

        for(int i = 1; i<height.length; i++){
            final int heightWall = Math.min(leftWalls[i], rightWalls[i]);
            if(height[i] < heightWall){
                gaps += (heightWall-height[i]);
            }
        }

        return gaps;
    }

}
