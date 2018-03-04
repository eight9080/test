package com.example.alg.mathpck;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class AddOperatorsTest {

    @Test
    public void addOperators() {

        final AddOperators a = new AddOperators();
        assertThat(a.addOperators("105", 5))
                .contains("1*0+5","10-5");

        assertThat(a.addOperators("232", 8))
                .contains("2*3+2", "2+3*2");

        assertThat(a.addOperators("123", 6))
                .contains("1+2+3", "1*2*3");


        assertThat(a.addOperators("00", 0))
                .contains("0+0", "0-0", "0*0");

        assertThat(a.addOperators("3456237490", 9191))
                .isEmpty();

    }
}