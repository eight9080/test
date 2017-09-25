package com.example.designpatterns.visitor.bank;

public interface IVisitor {

    void visit(RealEstate realEstate);
    void visit(BankAccount bankAccount);
    void visit(Loan loan);

}
