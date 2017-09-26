package com.example.alg.cache.lru;

import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {

    @Test
    public void get() throws Exception {
        final LRUCache lruCache = new LRUCache(3);
        lruCache.set(1, 1);
        lruCache.set(2, 2);
        lruCache.set(1, 10);
        lruCache.set(3, 3);
        lruCache.set(4, 4);
        assertEquals(4, lruCache.get(4));
        assertEquals(3, lruCache.get(3));
        assertEquals(-1, lruCache.get(2));
        assertEquals(10, lruCache.get(1));

    }

}