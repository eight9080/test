package com.example.alg.stringpck;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class FlipGameTest {
    @Test
    public void canWin() throws Exception {
        assertEquals(true, FlipGame.canWin("++++"));
        assertEquals(false, FlipGame.canWin("++--++"));
    }

    @Test
    public void generatePossibleNextMoves() throws Exception {
        assertEquals(asList("--++","+--+","++--"), FlipGame.generatePossibleNextMoves("++++"));
        assertEquals(Collections.emptyList(), FlipGame.generatePossibleNextMoves("----"));
        assertEquals(Collections.emptyList(), FlipGame.generatePossibleNextMoves("+--+"));
        assertEquals(asList("----++","++----"), FlipGame.generatePossibleNextMoves("++--++"));
    }

}