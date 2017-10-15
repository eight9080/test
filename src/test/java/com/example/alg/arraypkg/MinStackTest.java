package com.example.alg.arraypkg;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinStackTest {
    @Test
    public void push() throws Exception {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertEquals(-3, minStack.getMin());
        minStack.pop();
        assertEquals(0, minStack.top());
        assertEquals(-2, minStack.getMin());

    }

    @Test
    public void push_DuplicateElement() throws Exception {

        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        assertEquals(0, minStack.getMin());
        minStack.pop();
        assertEquals(0, minStack.getMin());
        minStack.pop();
        assertEquals(0, minStack.getMin());
        minStack.pop();
        assertEquals(2, minStack.getMin());


    }

    @Test
    public void push3() throws Exception {

        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        assertEquals(2, minStack.top());
        assertEquals(1, minStack.getMin());
        minStack.pop();
        assertEquals(1, minStack.getMin());
        assertEquals(1, minStack.top());


    }


}