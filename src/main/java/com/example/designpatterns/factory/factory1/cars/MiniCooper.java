package com.example.designpatterns.factory.factory1.cars;

import com.example.designpatterns.factory.factory1.IAuto;

public class MiniCooper implements IAuto {
    private  String name = "Mini Cooper";

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
        System.out.println("The "+name+" is on! 1.6 Liters of brutal force is churning.");
    }

    @Override
    public void turnOff() {
        System.out.println("The "+name+" is has turned off.");
    }
}
