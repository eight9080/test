package com.example.alg.segmenttreepck;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SkylineTest {


    @Test
    public void getSkyline() throws Exception {

        final Skyline s = new Skyline();
        final List<int[]> points = s.getSkyline(new int[][]{
                {2, 9, 10}, {3, 7, 15},
                {5, 12, 12}, {15, 20, 10}, {19, 24, 8}});

        int[][] pointsM = new int[points.size()][3];
        for (int i = 0; i<points.size(); i++) {
            pointsM[i] = points.get(i);
        }

        int[][] expectPointsM = new int[][]{
            {2, 10}, {3,15}, {7,12}, {12,0}, {15,10},
            {20,8}, {24,0}
        };

        assertArrayEquals(expectPointsM, pointsM);

    }

}