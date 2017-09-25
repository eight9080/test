package com.example.designpatterns.decorator;

public class SmallPizza extends Pizza {

    public SmallPizza() {
        description = "Small pizza";
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double calculateCost() {
        return 3.00;
    }
}
