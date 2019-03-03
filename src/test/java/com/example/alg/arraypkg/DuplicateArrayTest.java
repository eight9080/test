package com.example.alg.arraypkg;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DuplicateArrayTest {

    @Test
    public void findDuplicates() {

        final DuplicateArray d = new DuplicateArray();
        assertEquals(Arrays.asList(2,3), d.findDuplicates(new int []{4,3,2,7,8,2,3,1}));

    }
}