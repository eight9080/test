package com.example.alg.greedypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskSchedulerTest {

    @Test
    public void leastInterval() {
        final TaskScheduler t = new TaskScheduler();
        final int i = t.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);

        assertEquals(8, i);
    }
}