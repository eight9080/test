package com.example.oodesign.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PeekingIteratorTest {

    @Test
    public void peek() {
        final ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        final PeekingIterator it = new PeekingIterator(list.iterator());
        assertEquals(1, it.next().intValue());
        assertEquals(2, it.peek().intValue());
        assertEquals(2, it.next().intValue());
        assertEquals(3, it.next().intValue());
        assertFalse(it.hasNext());

    }

    @Test
    public void peek1() {
        final ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3,4));
        final PeekingIterator it = new PeekingIterator(list.iterator());
        assertTrue(it.hasNext());
        assertEquals(1, it.peek().intValue());
        assertEquals(1, it.peek().intValue());
        assertEquals(1, it.next().intValue());

        assertEquals(2, it.next().intValue());

        assertEquals(3, it.peek().intValue());
        assertEquals(3, it.peek().intValue());
        assertEquals(3, it.next().intValue());
        assertTrue(it.hasNext());

        assertEquals(4, it.peek().intValue());
        assertTrue(it.hasNext());
        assertEquals(4, it.next().intValue());

        assertFalse(it.hasNext());

    }
}