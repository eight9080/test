package com.example.alg.arraypkg;

import org.junit.Test;

import java.util.Arrays;

import static com.example.alg.arraypkg.IntervalsOps.interval;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class IntervalsOpsTest {

    @Test
    public void merge() throws Exception {
        assertThat(IntervalsOps.merge(asList(interval(1, 3), interval(2, 6), interval(8, 10), interval(15, 18))),
                is(asList(interval(1, 6), interval(8, 10), interval(15, 18))));
    }

    @Test
    public void insert() throws Exception {
        assertThat(IntervalsOps.insert(asList(interval(1, 3), interval(6, 9)), interval(2, 5)),
                is(asList(interval(1,5), interval(6,9))));
        assertThat(IntervalsOps.insert(asList(interval(1, 2), interval(3, 5), interval(6,7), interval(8,10), interval(12,16)),
                interval(4, 9)),
                is(asList(interval(1,2), interval(3,10), interval(12,16))));


    }
}