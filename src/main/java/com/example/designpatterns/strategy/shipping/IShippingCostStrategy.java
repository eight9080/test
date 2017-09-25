package com.example.designpatterns.strategy.shipping;


import java.util.function.Function;

public interface IShippingCostStrategy {

    Function<Order, Double> fedExStrategy = (order) -> 5.00d;
    Function<Order, Double> upsStrategy = (order) -> 4.25d;
    Function<Order, Double> uspsStrategy = (order) -> 3.00d;

}