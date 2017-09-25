package com.example.designpatterns.factory.factory1.cars;

import com.example.designpatterns.factory.factory1.IAuto;

public class NullCar implements IAuto {

    public static final NullCar NULL_CAR = new NullCar();

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }
}
