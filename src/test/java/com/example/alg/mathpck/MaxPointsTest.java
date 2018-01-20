package com.example.alg.mathpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxPointsTest {
    @Test
    public void maxPoints() throws Exception {
        final MaxPoints m = new MaxPoints();
        assertEquals(2, m.maxPoints(new Point[]{
                new Point(0,0),
                new Point(2,1),
                new Point(3,2)
        }));

        assertEquals(2, m.maxPoints(new Point[]{
                new Point(0,0),
                new Point(94911151,94911150),
                new Point(94911152,94911151)
        }));


        assertEquals(4, m.maxPoints(new Point[]{ new Point(-1,1),
                new Point(0,0),
                new Point(1,1),
                new Point(2,2),
                new Point(3,3),
                new Point(3,4)}));


    }

}