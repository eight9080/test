package com.example.alg.arraypkg;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DisappearedNumbersTest {

    @Test
    public void findDisappearedNumbers() {

        final DisappearedNumbers d = new DisappearedNumbers();
        final List<Integer> disappearedNumbers = d.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        final List<Integer> expect = Arrays.asList(5, 6);
        assertEquals(expect, disappearedNumbers);

    }

    @Test
    public void findDisappearedNumbers1() {

        final DisappearedNumbers d = new DisappearedNumbers();
        final List<Integer> disappearedNumbers = d.findDisappearedNumbers1(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        final List<Integer> expect = Arrays.asList(5, 6);
        assertEquals(expect, disappearedNumbers);

    }
}