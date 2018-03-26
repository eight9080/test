package com.example.alg.arraypkg;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MinIndexSumTest {

    @Test
    public void findRestaurant() {

        final MinIndexSum m = new MinIndexSum();
        final String[] restaurant = m.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"});
        assertArrayEquals(new String[]{"Shogun"}, restaurant);

    }


    @Test
    public void findRestaurant1() {

        final MinIndexSum m = new MinIndexSum();
        final String[] restaurant = m.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"KFC", "Shogun", "Burger King"});
        assertArrayEquals(new String[]{"Shogun"}, restaurant);

    }
}