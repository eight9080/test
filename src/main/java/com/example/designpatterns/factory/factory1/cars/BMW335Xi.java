package com.example.designpatterns.factory.factory1.cars;

import com.example.designpatterns.factory.factory1.IAuto;

public class BMW335Xi implements IAuto {

    private String name = "BMW 335Xi";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void turnOn() {
        System.out.println("The "+name+" is on and running.");
    }

    @Override
    public void turnOff() {
        System.out.println("The "+name+" is off.");
    }
}
