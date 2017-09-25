package com.example.designpatterns.mediator;

import com.example.designpatterns.mediator.airplanes.*;
import org.junit.Test;

public class YytCenterTest {

    @Test
    public void fly() throws Exception {
        final YytCenter yytCenter = new YytCenter();
        final Aircraft flight1 = new Airbus321("AC100", yytCenter);
        final Aircraft flight2 = new Boeing737200("WS200", yytCenter);
        final Aircraft flight3 = new Embraer190("EM300", yytCenter);

        flight1.setAltitude(1000);

    }
}