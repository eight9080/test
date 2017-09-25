package com.example.designpatterns.visitor.bank;

public class IncomeVisitor implements IVisitor {

    private double amount;

    public double getAmount() {
        return amount;
    }

    @Override
    public void visit(RealEstate realEstate) {
        amount+=realEstate.getMonthlyRent();
    }

    @Override
    public void visit(BankAccount bankAccount) {
        amount += bankAccount.getAmount()* bankAccount.getMonthlyInterest();
    }

    @Override
    public void visit(Loan loan) {
        amount-=loan.getMonthlyPayment();
    }
}
