package com.example.designpatterns.mediator.airplanes;

public class Airbus321 extends Aircraft{


    public Airbus321(String callSign, IAirTrafficControl atc) {
        super(callSign, atc);
    }

    @Override
    public int getCeiling() {
        return 41000;
    }
}
