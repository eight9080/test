package com.example.designpatterns.state;

public class FanHignState extends State {

    private Fan fan;

    public FanHignState(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void handleRequest(){
        System.out.println("Turning fan on to off");
        fan.setState(fan.getFanOffState());
    }

    @Override
    public String toString() {
        return "Fan is hign.";
    }
}
