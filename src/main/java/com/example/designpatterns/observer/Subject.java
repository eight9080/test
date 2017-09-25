package com.example.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    abstract void setState(String state);
    abstract String getState();

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void deattach(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        observers.forEach(observer -> observer.update());
    }


}