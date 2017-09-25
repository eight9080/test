package com.example.designpatterns.mediator.airplanes;

public class Boeing737200 extends Aircraft{


    public Boeing737200(String callSign, IAirTrafficControl atc) {
        super(callSign, atc);
    }

    @Override
    public int getCeiling() {
        return 35000;
    }
}
