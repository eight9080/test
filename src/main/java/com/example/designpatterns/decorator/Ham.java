package com.example.designpatterns.decorator;

public class Ham extends PizzaDecorator{

    public Ham(Pizza pizza) {
        super(pizza);
        description = "Ham";
    }

    @Override
    public String getDescription() {
        return super.getDescription() +", "+ description;
    }

    @Override
    public double calculateCost() {
        return super.calculateCost() + 1.00;
    }
}
