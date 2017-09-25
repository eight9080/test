package com.example.designpatterns.decorator;

public abstract class Pizza {

    protected String description;

    public abstract String getDescription();

    public abstract double calculateCost();
}
