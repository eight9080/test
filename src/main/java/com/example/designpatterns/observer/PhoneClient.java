package com.example.designpatterns.observer;

public class PhoneClient extends Observer {


    public PhoneClient(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    void update() {
        System.out.println("Phone Stream: "+subject.getState());
    }

    public void addMessage(String message) {
        subject.setState(message+" - sent from phone");
    }
}