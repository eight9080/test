package com.example.oodesign.callcenter;

public class Respondent extends Employee {
    public Respondent(CallHandler callHandler) {
        super(callHandler);
        rank = Rank.Responder;
    }
}
