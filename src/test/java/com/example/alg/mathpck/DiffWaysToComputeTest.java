package com.example.alg.mathpck;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DiffWaysToComputeTest {

    @Test
    public void diffWaysToCompute() {

        final DiffWaysToCompute d = new DiffWaysToCompute();

        Assertions.assertThat(d.diffWaysToCompute("2-1-1"))
                .contains(0,2);
        Assertions.assertThat(d.diffWaysToCompute("2*3-4*5"))
                .contains(-34, -14, -10, -10, 10);
    }
}