package com.example.designpatterns.observer;

public abstract class Observer {
    protected Subject subject;
    abstract void update();
}