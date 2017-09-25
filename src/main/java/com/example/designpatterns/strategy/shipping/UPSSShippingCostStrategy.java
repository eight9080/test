package com.example.designpatterns.strategy.shipping;

public class UPSSShippingCostStrategy implements IShippingCostStrategy{

    public double calculate(Order order) {
        return 3.00d;
    }
}
