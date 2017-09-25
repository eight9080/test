package com.example.designpatterns.mediator.airplanes;

public interface IAirTrafficControl {
    void receiveAircraftLocation(Aircraft aircraft);
    void registerAircraftUnderGuidance(Aircraft aircraft);
}
