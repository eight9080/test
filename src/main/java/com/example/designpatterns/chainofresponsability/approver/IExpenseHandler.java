package com.example.designpatterns.chainofresponsability.approver;

public interface IExpenseHandler {

    ApprovalResponse approve(IExpenseReport expenseReport);
    void registerNext(IExpenseHandler next);

}