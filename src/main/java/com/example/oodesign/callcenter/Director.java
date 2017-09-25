package com.example.oodesign.callcenter;

public class Director extends Employee {
    public Director(CallHandler callHandler) {
        super(callHandler);
        rank = Rank.Director;
    }
}
