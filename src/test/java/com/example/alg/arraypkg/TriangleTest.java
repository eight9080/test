package com.example.alg.arraypkg;

import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void minimumTotal() throws Exception {
        final Triangle t = new Triangle();

        assertEquals(-1,
                t.minimumTotal(asList(
                        singletonList(-1),
                        asList(2,3),
                        asList(1,-1,-3)
                )));


        assertEquals(14,
                t.minimumTotal(asList(
                        singletonList(2),
                        asList(3,4),
                        asList(6,5,9),
                        asList(4,4,8,0)
                )));


        assertEquals(11,
                t.minimumTotal(asList(
                        singletonList(2),
                        asList(3,4),
                        asList(6,5,7),
                        asList(4,1,8,3)
                )));
    }

}