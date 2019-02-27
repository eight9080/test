package com.example.alg;

import com.example.alg.stringpck.ReverseWords;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseWordsTest {

    @Test
    public void reverseString() throws Exception {
        assertEquals("example good a", ReverseWords.reverseStringJava8("a good  example"));
        assertEquals("blue is sky the", ReverseWords.reverseString("the sky is blue"));
        assertEquals("blue is sky the", ReverseWords.reverseStringJava8("the sky is blue"));
    }

    @Test
    public void reverseStringWithSpecialCharacters(){
        assertEquals("c,b$a", ReverseWords.reverseStringWithSpecialCharacters("a,b$c"));
        assertEquals("ed,c,bA!$", ReverseWords.reverseStringWithSpecialCharacters("Ab,c,de!$"));
    }

    @Test
    public void reverseStringSimple() {

        final ReverseWords r = new ReverseWords();
        final String hello = r.reverseStringSimple("hello");
        Assertions.assertThat(hello).isEqualTo("olleh");
    }
}