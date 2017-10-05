package com.example.alg.stringpck;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class GroupStringsTest {
    @Test
    public void groupStrings() throws Exception {
        final List<List<String>> expected = asList(asList("a", "z"),
                asList("abc", "bcd", "xyz"), asList("az", "ba"),
                asList("acef") );
        final List<List<String>> actualResult = GroupStrings.groupStrings(new String[]{"abc", "az", "a",
                "acef", "bcd", "xyz", "ba", "z"});
        assertEquals(expected, actualResult);

    }

    @Test
    public void groupStringsReverse() throws Exception {
        final List<List<String>> expected = asList(
                asList( "bcd", "xyz"));
        final List<List<String>> actualResult = GroupStrings.groupStrings(new String[]{
                "bcd", "xyz"});
        assertEquals(expected, actualResult);

    }


}