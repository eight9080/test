package com.example.alg.arraypkg;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class GetTargetTest {


    @Test
    public void isReachable() throws Exception {
        assertEquals(true, GetTarget.isReachable(asList(1, 2, 3, 4), 21));
    }

}