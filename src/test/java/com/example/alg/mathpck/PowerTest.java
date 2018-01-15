package com.example.alg.mathpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class PowerTest {

    final Power p = new Power();

    @Test
    public void isPowerOfFour() throws Exception {
        assertTrue(p.isPowerOfFour(16));
        assertFalse(p.isPowerOfFour(34));
    }



    @Test
    public void isPowerOfThree() throws Exception {
        assertTrue(p.isPowerOfThree(9));
        assertFalse(p.isPowerOfThree(34));
    }



    @Test
    public void isPowerOfTwo() throws Exception {

        assertTrue(p.isPowerOfTwo(256));
        assertFalse(p.isPowerOfTwo(34));

    }

    @Test
    public void myPow() throws Exception {



        assertEquals(1.00000, p.myPow(1.00000, -2147483648), 0);
        assertEquals(1024.00000, p.myPow(2.00000, 10), 0);
        assertEquals(9.26100, p.myPow(2.10000, 3), 1);

        assertEquals(1, p.myPow(3,0), 0);
        assertEquals(3, p.myPow(3,1), 0);
        assertEquals(9, p.myPow(3,2), 0);



    }

}