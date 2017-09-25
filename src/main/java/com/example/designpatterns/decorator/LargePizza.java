package com.example.designpatterns.decorator;

public class LargePizza extends Pizza {

    public LargePizza() {
        description = "Large Pizza";
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double calculateCost() {
        return 9.00;
    }
}
