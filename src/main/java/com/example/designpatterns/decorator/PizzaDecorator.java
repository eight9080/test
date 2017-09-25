package com.example.designpatterns.decorator;

public class PizzaDecorator extends Pizza{

    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double calculateCost() {

        return pizza.calculateCost();
    }
}
