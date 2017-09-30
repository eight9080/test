package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerToEnglishTest {
    @Test
    public void numberToWordsLess100() throws Exception {
        final IntegerToEnglish toEnglish = new IntegerToEnglish();
        assertEquals("Twelve", toEnglish.numberToWords(12));
        assertEquals("Forty Five", toEnglish.numberToWords(45));

    }

    @Test
    public void numberToWords() throws Exception {
        final IntegerToEnglish toEnglish = new IntegerToEnglish();
        assertEquals("One Hundred Twenty Three", toEnglish.numberToWords(123));
        assertEquals("Twelve Thousand Three Hundred Forty Five", toEnglish.numberToWords(12345));

    }

}