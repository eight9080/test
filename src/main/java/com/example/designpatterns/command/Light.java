package com.example.designpatterns.command;

//receiver
public class Light {

    private boolean isOn = false;

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