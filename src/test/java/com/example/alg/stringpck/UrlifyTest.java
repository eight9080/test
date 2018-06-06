package com.example.alg.stringpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class UrlifyTest {

    @Test
    public void replaceSpaces() {

        final Urlify u = new Urlify();
        final String urlifyStr = u.replaceSpaces("Mr John Smith    ");
        assertEquals("Mr%20John%20Smith", urlifyStr);

    }
}