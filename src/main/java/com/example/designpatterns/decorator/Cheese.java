package com.example.designpatterns.decorator;

public class Cheese extends PizzaDecorator{

    public Cheese(Pizza pizza) {
        super(pizza);
        description = "Cheese";
    }

    @Override
    public String getDescription() {
        return super.getDescription() +", "+ description;
    }

    @Override
    public double calculateCost() {
        return super.calculateCost() + 1.25;
    }
}
