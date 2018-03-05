package com.example.alg.arraypkg;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PolishNotationTest {
    @Test
    public void evalRPN() throws Exception {
        assertThat(new PolishNotation().evalRPN(new String[]{"4","3","-"}), is(1));
        assertThat(new PolishNotation().evalRPN(new String[]{"2", "1", "+", "3", "*"}), is(9));
        assertThat(new PolishNotation().evalRPN(new String[]{"4", "13", "5", "/", "+"}), is(6));
    }

}