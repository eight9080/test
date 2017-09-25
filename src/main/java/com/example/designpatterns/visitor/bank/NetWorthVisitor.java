package com.example.designpatterns.visitor.bank;

public class NetWorthVisitor implements IVisitor {

    private int total;

    public int getTotal() {
        return total;
    }

    @Override
    public void visit(RealEstate realEstate) {
        total+=realEstate.getEstimatedValue();
    }

    @Override
    public void visit(BankAccount bankAccount) {
        total+=bankAccount.getAmount();
    }

    @Override
    public void visit(Loan loan) {
        total-=loan.getOwed();
    }
}
