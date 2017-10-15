package com.example.alg.arraypkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.
 */
public class MinStack {

    private Elem  head;


    public MinStack() {

    }

    public void push(int x) {
        if(head==null){
            head = new Elem(x,x);
        }else {
            Elem newHead = new Elem(x, Math.min(x, head.min));
            newHead.next = head;
            head= newHead;
        }
    }

    public void pop() {
        if(head!=null) {
            final Elem newHead = this.head.next;
            this.head.next = null;
            this.head = newHead;
        }
    }

    public int top() {
        if(head!=null){
            return this.head.value;
        }else{
            return -1;
        }
    }

    public int getMin() {
        if(head!=null){
           return this.head.min;
        }
        return -1;
    }


}

class Elem {
    public int value;
    public int min;
    public Elem next;

    public Elem(int value, int min){
        this.value = value;
        this.min = min;
    }
}