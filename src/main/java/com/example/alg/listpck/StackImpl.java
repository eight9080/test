package com.example.alg.listpck;

/**
 * The requirements of the stack are:
 * 1) the stack has a constructor which accept a number to initialize its size,
 * 2) the stack can hold any type of elements,
 * 3) the stack has a push() and a pop() method.
 * @param <T>
 */
public class StackImpl<T> {

    private T[] arr = null;
    private int capacity = 10;
    private int top = -1;
    private int size = 0;


    public StackImpl(int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
    }

    public boolean push(T elem){
        if(isFull()){
            return false;
        }
        this.arr[++this.top] = elem;
        this.size++;
        return true;
    }

    public T pop(){
        if(isEmpty()){
            return null;
        }
        final T elem = arr[top];
        arr[top]=null;
        this.top--;
        this.size--;
        return elem;
    }

    public boolean isFull(){
        return this.capacity == this.size;
    }

    public boolean isEmpty(){
        return this.size==0;
    }


    public String toString() {
        if(isEmpty()){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=top; i>=0; i--){
            sb.append(this.arr[i] + ", ");
        }

        sb.setLength(sb.length()-2);
        return sb.toString();
    }


}
