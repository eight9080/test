package com.example.alg.listpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackImplTest {
    @Test
    public void push() throws Exception {
        final StackImpl<String> stack = new StackImpl<>(3);
        stack.push("hello");
        stack.push("world");

        assertEquals("world, hello", stack.toString());

        stack.pop();
        assertEquals("hello", stack.toString());

        stack.pop();
        assertNull(stack.toString());
    }

}