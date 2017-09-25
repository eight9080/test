package com.example.designpatterns.chainofresponsability.approverCEO;

import org.junit.Test;

import static org.junit.Assert.*;

public class HandlerTest {
    @Test
    public void handleRequest() throws Exception {
        final Director director = new Director();
        final VP vp = new VP();
        final CEO ceo = new CEO();

        director.setSuccessor(vp);;
        vp.setSuccessor(ceo);

        //director.handleRequest(new Request(RequestType.CONFERENCE, 500));
        director.handleRequest(new Request(RequestType.PURCHASE, 1000));
        //director.handleRequest(new Request(RequestType.PURCHASE, 2000));
    }

}