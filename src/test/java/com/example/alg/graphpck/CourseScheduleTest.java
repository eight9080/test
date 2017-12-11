package com.example.alg.graphpck;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CourseScheduleTest {
    final CourseSchedule c = new CourseSchedule();
    @Test
    public void findOrder() throws Exception {
        assertArrayEquals(new int[]{0,1},c.findOrder(2, new int[][]{{1, 0}}));
        final int[] order = c.findOrder(4,
                new int[][]{{1, 0}, {2,0}, {3,1}, {3,2}});

        assertTrue(Arrays.equals(new int[]{0,1,2,3}, order)
                || Arrays.equals(new int[]{0,2,1,3}, order));

        assertArrayEquals(new int[]{},c.findOrder(2, new int[][]{{1, 0}, {0,1}}));
    }

    @Test
    public void canFinish() throws Exception {


        assertTrue(c.canFinish(2, new int[][]{{1, 0}}));
        assertFalse(c.canFinish(2, new int[][]{{1, 0}, {0,1}}));

    }

}