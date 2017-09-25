package com.example.designpatterns.bridge.books;

public abstract class Manuscript {

    protected final IFormatter formatter;

    public  Manuscript(IFormatter formatter){
        this.formatter = formatter;
    }

    public abstract void print();
}
