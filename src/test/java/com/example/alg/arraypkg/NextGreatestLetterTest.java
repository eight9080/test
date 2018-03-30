package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class NextGreatestLetterTest {

    @Test
    public void nextGreatestLetter() {

        final NextGreatestLetter n = new NextGreatestLetter();
        assertEquals('c', n.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        assertEquals('f', n.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        assertEquals('f', n.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
        assertEquals('j', n.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g'));
        assertEquals('c', n.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
        assertEquals('c', n.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k'));
    }
}
