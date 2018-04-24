package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class AsteroidTest {

    @Test
    public void asteroidCollision() {

        final Asteroid a = new Asteroid();
        final int[] result = a.asteroidCollision(new int[]{5, 10, -5});
        final int[] expected = {5, 10};
        assertArrayEquals(expected, result);

    }

    @Test
    public void asteroidCollision1() {

        final Asteroid a = new Asteroid();
        final int[] result = a.asteroidCollision(new int[]{8,-8});
        final int[] expected = {};
        assertArrayEquals(expected, result);

    }


    @Test
    public void asteroidCollision2() {

        final Asteroid a = new Asteroid();
        final int[] result = a.asteroidCollision(new int[]{10,2,-5});
        final int[] expected = { 10};
        assertArrayEquals(expected, result);

    }


    @Test
    public void asteroidCollision3() {

        final Asteroid a = new Asteroid();
        final int[] result = a.asteroidCollision(new int[]{-2,-1,1,2});
        final int[] expected = {-2,-1,1,2};
        assertArrayEquals(expected, result);

    }

    @Test
    public void asteroidCollision4() {

        final Asteroid a = new Asteroid();
        final int[] result = a.asteroidCollision(new int[]{-2,-2,1,-2});
        final int[] expected = { -2,-2,-2};
        assertArrayEquals(expected, result);

    }

    @Test
    public void asteroidCollision5() {

        final Asteroid a = new Asteroid();
        final int[] result = a.asteroidCollision(new int[]{-2,2,1,-2});
        final int[] expected = { -2};
        assertArrayEquals(expected, result);

    }
}