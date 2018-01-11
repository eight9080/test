package com.example.alg.permutations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class PhoneNumberTest {
    @Test
    public void letterCombinations() throws Exception {

        final PhoneNumber p = new PhoneNumber();
         assertEquals(new ArrayList<>(), p.letterCombinations(""));

        final List<String> combinations = p.letterCombinations("23");

        final List<String> expect = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        assertEquals(expect, combinations);

    }

}