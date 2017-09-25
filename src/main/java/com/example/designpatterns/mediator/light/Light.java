package com.example.designpatterns.mediator.light;

//receiver
public class Light {

    private String room;

    private boolean isOn = false;

    public Light(String room) {
        this.room = room;
    }

    public boolean isOn() {
        return isOn;
    }

    public void toggle() {
        this.isOn = !isOn;
        if (isOn) {
            on();
        } else {
            off();
        }
    }

    public void on() {
        System.out.println("Light switched on.");
    }

    public void off() {
        System.out.println("Light switched off.");
    }
}