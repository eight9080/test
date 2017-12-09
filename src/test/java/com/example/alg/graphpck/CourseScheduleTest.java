package com.example.alg.graphpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class CourseScheduleTest {
    @Test
    public void canFinish() throws Exception {

        final CourseSchedule c = new CourseSchedule();
        assertTrue(c.canFinish(2, new int[][]{{1, 0}}));
        assertFalse(c.canFinish(2, new int[][]{{1, 0}, {0,1}}));

    }

}