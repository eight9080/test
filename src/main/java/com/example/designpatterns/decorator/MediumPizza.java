package com.example.designpatterns.decorator;

public class MediumPizza extends Pizza{

    public MediumPizza() {
        description = "Medium Pizza";
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double calculateCost() {
        return 6.00;
    }
}
