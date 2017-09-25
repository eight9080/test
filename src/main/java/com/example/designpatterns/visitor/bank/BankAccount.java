package com.example.designpatterns.visitor.bank;

public class BankAccount implements IAsset{
    private int amount;
    private double monthlyInterest;

    public BankAccount(int amount, double monthlyInterest) {
        this.amount = amount;
        this.monthlyInterest = monthlyInterest;
    }

    public int getAmount() {
        return amount;
    }

    public double getMonthlyInterest() {
        return monthlyInterest;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
