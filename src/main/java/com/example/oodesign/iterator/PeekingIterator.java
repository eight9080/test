package com.example.oodesign.iterator;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer nextElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator=iterator;
        advance();

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer returnElement = this.nextElement;
        advance();
        return returnElement;
    }

    @Override
    public boolean hasNext() {
        return this.nextElement!=null;
    }

    private void advance(){
        if(this.iterator.hasNext()){
            this.nextElement=this.iterator.next();
        }else {
            this.nextElement=null;
        }
    }

}
