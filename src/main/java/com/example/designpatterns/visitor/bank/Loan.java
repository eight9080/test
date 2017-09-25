package com.example.designpatterns.visitor.bank;

public class Loan implements IAsset{

    private int owed;
    private int monthlyPayment;

    public Loan(int owed, int monthlyPayment) {
        this.owed = owed;
        this.monthlyPayment = monthlyPayment;
    }

    public int getOwed() {
        return owed;
    }

    public int getMonthlyPayment() {
        return monthlyPayment;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
