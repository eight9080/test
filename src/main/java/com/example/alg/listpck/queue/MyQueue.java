package com.example.alg.listpck.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {

    private final Deque<Integer> values;

    /** Initialize your data structure here. */
    public MyQueue() {
        values = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        if(values.isEmpty()){
            values.push(x);
        }else {
            Deque<Integer> temp = new ArrayDeque<>();
            while (!values.isEmpty()){
                temp.push(values.pop());
            }

            values.push(x);

            while (!temp.isEmpty()){
                values.push(temp.pop());
            }
        }

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return values.pop();
    }

    /** Get the front element. */
    public int peek() {
        return values.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return values.isEmpty();
    }

}
