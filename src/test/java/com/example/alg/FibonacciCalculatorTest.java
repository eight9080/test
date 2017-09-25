package com.example.alg;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FibonacciCalculatorTest {

    private List<Integer> expectedResult =  Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55);

    @Test
    public void fibonacciRecList() throws Exception {
        assertThat(FibonacciCalculator.fibonacciRecList(10), is(expectedResult));
    }

    @Test
    public void fibonacciIterativeList() throws Exception {
        assertThat(FibonacciCalculator.fibonacciIterativeList(10), is(expectedResult));
    }

}