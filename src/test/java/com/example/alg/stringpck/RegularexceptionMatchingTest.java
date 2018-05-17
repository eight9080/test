package com.example.alg.stringpck;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static com.example.alg.stringpck.RegularexceptionMatching.isMatch;

public class RegularexceptionMatchingTest {
    @Test
    public void isMatchTest() throws Exception {
        assertThat(isMatch("aa", "a"), is(false));
        assertThat(isMatch("aa", "aa"), is(true));
        assertThat(isMatch("aaa", "aa"), is(false));
        assertThat(isMatch("aa", "a*"), is(true));
        assertThat(isMatch("aa", ".*"), is(true));
        assertThat(isMatch("ab", ".*"), is(true));
        assertThat(isMatch("aab", "c*a*b"), is(true));
    }

    @Test
    public void checkRecord() {

        final RegularexceptionMatching r = new RegularexceptionMatching();
        assertTrue(r.checkRecord("PPALLP"));
        assertFalse(r.checkRecord("PPALLL"));
    }
}