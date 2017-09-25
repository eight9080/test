package com.example.designpatterns.strategy.shipping;

import java.util.function.Function;

public class ShippingCostCalculatorService {

    private Function<Order, Double> shippingCostStrategy;

    public ShippingCostCalculatorService(Function<Order, Double> shippingCostStrategy) {
        this.shippingCostStrategy = shippingCostStrategy;
    }

    public double calculateShippingCost(Order order){
        return shippingCostStrategy.apply(order);
    }
}
