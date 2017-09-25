package com.example.designpatterns.strategy.shipping;

public class UPSShippingCostStrategy implements IShippingCostStrategy{

    public double calculate(Order order) {
        return 4.25d;
    }
}
