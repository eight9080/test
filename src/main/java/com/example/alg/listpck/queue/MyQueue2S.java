package com.example.alg.listpck.queue;

import java.util.Stack;

public class MyQueue2S<T> {

    private Stack<T> newestStack;
    private Stack<T> oldestStack;

    public MyQueue2S() {
        newestStack = new Stack<>();
        oldestStack = new Stack<>();
    }

    public int size(){
        return newestStack.size()+oldestStack.size();
    }

    public void add(T value){
        newestStack.push(value);
    }

    public T peek(){
        shiftStacks();
        return oldestStack.peek();
    }

    public T remove(){
        shiftStacks();
        return oldestStack.pop();
    }

    private void shiftStacks() {
        if(oldestStack.isEmpty()){
            while (!newestStack.isEmpty()){
                oldestStack.push(newestStack.pop());
            }
        }
    }

}
