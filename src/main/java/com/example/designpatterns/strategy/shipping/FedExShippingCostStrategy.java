package com.example.designpatterns.strategy.shipping;

public class FedExShippingCostStrategy implements IShippingCostStrategy{

    public double calculate(Order order) {
        return 5.00d;
    }
}
