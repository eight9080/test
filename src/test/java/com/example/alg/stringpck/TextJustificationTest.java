package com.example.alg.stringpck;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TextJustificationTest {
    @Test
    public void fullJustify() throws Exception {
        final List<String> result = TextJustification.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."},
                16);
        assertEquals(Arrays.asList("This    is    an","example  of text","justification.  "), result);
    }

    @Test
    public void fullJustifyS() throws Exception {
        final List<String> result = TextJustification.fullJustifyS(new String[]{"This", "is", "an", "example", "of", "text", "justification."},
                16);
        assertEquals(Arrays.asList("This    is    an","example  of text","justification.  "), result);
    }


}