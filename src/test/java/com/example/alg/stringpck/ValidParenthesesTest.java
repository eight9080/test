package com.example.alg.stringpck;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ValidParenthesesTest {
    @Test
    public void checkParentheses() throws Exception {
        assertThat(ValidParentheses.checkParentheses("()"), is(true));
        assertThat(ValidParentheses.checkParentheses("()[]{}"), is(true));
        assertThat(ValidParentheses.checkParentheses("(]"), is(false));
        assertThat(ValidParentheses.checkParentheses("([)]"), is(false));
    }

}