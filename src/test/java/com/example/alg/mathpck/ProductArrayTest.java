package com.example.alg.mathpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductArrayTest {
    public void productExceptSelf3() throws Exception {
        final ProductArray p = new ProductArray();
        assertArrayEquals(new int[]{24,12,8,6}, p.productExceptSelf3(new int[]{1,2,3,4}));

    }
    @Test
    public void productExceptSelf2() throws Exception {
        final ProductArray p = new ProductArray();
        assertArrayEquals(new int[]{24,12,8,6}, p.productExceptSelf2(new int[]{1,2,3,4}));

    }

    @Test
    public void productExceptSelf() throws Exception {

        final ProductArray p = new ProductArray();
        assertArrayEquals(new int[]{24,12,8,6}, p.productExceptSelf(new int[]{1,2,3,4}));

    }

}