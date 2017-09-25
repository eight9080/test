package com.example.designpatterns.mediator.airplanes;

public abstract class Aircraft {

    private String callSign;
    private IAirTrafficControl atc;
    private int currentAltitude;

    public Aircraft(String callSign, IAirTrafficControl atc) {
        this.callSign = callSign;
        this.atc = atc;
        this.atc.registerAircraftUnderGuidance(this);
    }

    public abstract int getCeiling();

    public String getCallSign() {
        return callSign;
    }

    public int altitude(){
        return currentAltitude;
    }

    public void setAltitude(int altitude){
        this.currentAltitude = altitude;
        atc.receiveAircraftLocation(this);
    }

    public void climb(int heightToClimb){
        setAltitude(heightToClimb);
    }

    public void warnOfAirspaceIntrusionBy(Aircraft reportingAircraft) {
        System.out.println("warnOfAirspaceIntrusionBy "+reportingAircraft.getCallSign());

    }
}
