package com.example.alg.arraypkg;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class MajorityElementTest {
    @Test
    public void majorityElement1() throws Exception {
        final MajorityElement m = new MajorityElement();
        assertEquals(2, m.majorityElement1(new int[]{1,3,2,4,2,2}));
    }

    @Test
    public void majorityElement2() throws Exception {
        final MajorityElement m = new MajorityElement();
        assertEquals(Arrays.asList(8,9), m.majorityElement2(new int[]{8,9,8,9,8}));
        assertEquals(Collections.emptyList(), m.majorityElement2(new int[]{1,2,3}));
        assertEquals(Arrays.asList(8,7), m.majorityElement2(new int[]{8,8,7,7,7}));
        assertEquals(Collections.emptyList(), m.majorityElement2(new int[]{}));
        assertEquals(Arrays.asList(1), m.majorityElement2(new int[]{1,1,4,2,1,2}));

//        assertEquals(Arrays.asList(1,2), m.majorityElement2(new int[]{1,1,4,2,3,2}));
    }

}