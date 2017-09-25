package com.example.designpatterns.mediator.airplanes;

import java.util.ArrayList;
import java.util.List;

public class YytCenter implements IAirTrafficControl {

    private List<Aircraft> aircraftsUnderGuidance = new ArrayList<>();

    @Override
    public void receiveAircraftLocation(Aircraft reportingAircraft) {
        aircraftsUnderGuidance.stream()
                .filter(aircraft -> aircraft!=reportingAircraft)
                .forEach(aircraft -> {
                    if(Math.abs(aircraft.altitude()-reportingAircraft.altitude())<1000){
                        reportingAircraft.climb(1000);
                        aircraft.warnOfAirspaceIntrusionBy(reportingAircraft);
                    }
                });
    }

    @Override
    public void registerAircraftUnderGuidance(Aircraft aircraft) {
        if(!aircraftsUnderGuidance.contains(aircraft)){
            aircraftsUnderGuidance.add(aircraft);
        }
    }
}
