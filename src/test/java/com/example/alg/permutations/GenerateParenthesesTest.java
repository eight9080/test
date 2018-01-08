package com.example.alg.permutations;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GenerateParenthesesTest {

    @Test
    public void generateParenthesis() throws Exception {

        final GenerateParentheses g = new GenerateParentheses();
        final List<String> strings = g.generateParenthesis(3);

        final List<String> expect = Arrays.asList("((()))", "(()())", "(())()",
                "()(())", "()()()");
        assertEquals(expect, strings);
    }

}