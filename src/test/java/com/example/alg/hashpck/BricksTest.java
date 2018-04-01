package com.example.alg.hashpck;

import org.junit.Test;

import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class BricksTest {

    @Test
    public void leastBricks() {
        final Bricks b = new Bricks();
        final int leastBricks = b.leastBricks(
                asList(
                        asList(1, 2, 2, 1),
                        asList(3, 1, 2),
                        asList(1, 3, 2),
                        asList(2, 4),
                        asList(3, 1, 2),
                        asList(1, 3, 1, 1)
                )
        );

        assertEquals(2, leastBricks);
    }
}
