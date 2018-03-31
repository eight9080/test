package com.example.alg.random;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FixxBuzzTest {

    @Test
    public void fizzBuzz() {

        final FixxBuzz f = new FixxBuzz();
        final List<String> output = f.fizzBuzz(15);
        final List<String> expected = Arrays.asList("1",
                "2",
                "Fizz",
                "4",
                "Buzz",
                "Fizz",
                "7",
                "8",
                "Fizz",
                "Buzz",
                "11",
                "Fizz",
                "13",
                "14",
                "FizzBuzz");

        assertEquals(expected, output);
    }
}
