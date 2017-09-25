package com.example.designpatterns.visitor.bank;

public class RealEstate implements IAsset{

    private int estimatedValue;
    private int monthlyRent;

    public RealEstate(int estimatedValue, int monthlyRent) {
        this.estimatedValue = estimatedValue;
        this.monthlyRent = monthlyRent;
    }

    public int getEstimatedValue() {
        return estimatedValue;
    }

    public int getMonthlyRent() {
        return monthlyRent;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
