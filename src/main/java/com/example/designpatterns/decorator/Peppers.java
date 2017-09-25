package com.example.designpatterns.decorator;

public class Peppers extends PizzaDecorator{

    public Peppers(Pizza pizza) {
        super(pizza);
        description = "Peppers";
    }

    @Override
    public String getDescription() {
        return super.getDescription() +", "+ description;
    }

    @Override
    public double calculateCost() {
        return super.calculateCost() + 2.00;
    }
}
