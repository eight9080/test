package com.example.alg.listpck.stack;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyStackTest {
    @Test
    @Ignore
    public void push() throws Exception {

        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        assertEquals(2, obj.pop());
        assertEquals(1, obj.top());
        assertFalse(obj.empty());
    }

}