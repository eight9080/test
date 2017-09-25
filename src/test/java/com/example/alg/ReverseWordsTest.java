package com.example.alg;

import com.example.alg.stringpck.ReverseWords;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseWordsTest {

    @Test
    public void reverseString() throws Exception {
        assertEquals("blue is sky the", ReverseWords.reverseString("the sky is blue"));
        assertEquals("blue is sky the", ReverseWords.reverseStringJava8("the sky is blue"));
    }
}