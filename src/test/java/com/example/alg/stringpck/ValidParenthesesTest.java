package com.example.alg.stringpck;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ValidParenthesesTest {
    @Test
    public void checkParentheses()  {
        assertThat(ValidParentheses.checkParentheses("()"), is(true));
        assertThat(ValidParentheses.checkParentheses("()[]{}"), is(true));
        assertThat(ValidParentheses.checkParentheses("(]"), is(false));
        assertThat(ValidParentheses.checkParentheses("([)]"), is(false));
    }

    @Test
    public void longestValidParentheses() {

        final ValidParentheses v = new ValidParentheses();
        assertEquals(4, v.longestValidParentheses(")()())"));
        assertEquals(2, v.longestValidParentheses("(()"));
    }
}