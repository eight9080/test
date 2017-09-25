package com.example.designpatterns.mediator.airplanes;

public class Embraer190 extends Aircraft{


    public Embraer190(String callSign, IAirTrafficControl atc) {
        super(callSign, atc);
    }

    @Override
    public int getCeiling() {
        return 41000;
    }
}
