package com.example.alg.mathpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExcelSheetColumnTitleTest {

    final ExcelSheetColumnTitle e = new ExcelSheetColumnTitle();

    @Test
    public void titleToNumber() throws Exception {
        assertEquals(27, e.titleToNumber("AA"));
        assertEquals(28, e.titleToNumber("AB"));
    }

    @Test
    public void convertToTitle() throws Exception {


        assertEquals("AA", e.convertToTitle(27));
        assertEquals("AB", e.convertToTitle(28));

    }

}