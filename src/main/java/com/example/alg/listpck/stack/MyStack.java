package com.example.alg.listpck.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 empty() -- Return whether the stack is empty.
 */
public class MyStack {

    private Queue queue;



    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        Queue q = new LinkedList();     // could be any queue type, see note above
        q.add(x);
        q.add(queue);
        queue = q;

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
            return 0;
    }

    /** Get the top element. */
    public int top() {
        return 0;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {

        return false;

    }
}
