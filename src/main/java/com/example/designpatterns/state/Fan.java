package com.example.designpatterns.state;

public class Fan {

    State fanOffState;
    State fanLowState;
    State fanMedState;
    State fanHighState;

    State state;

    public Fan() {
        fanOffState = new FanOffState(this);
        fanLowState = new FanLowState(this);
        fanMedState = new FanMedState(this);
        fanHighState = new FanHignState(this);

        state = fanOffState;
    }

    public void pullChain(){
        state.handleRequest();
    }

    public String toString(){
        return state.toString();
    }

    public State getFanLowState() {
        return fanLowState;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getFanMedState() {
        return fanMedState;
    }

    public State getFanOffState() {
        return fanOffState;
    }

    public State getFanHighState() {
        return fanHighState;
    }
}
