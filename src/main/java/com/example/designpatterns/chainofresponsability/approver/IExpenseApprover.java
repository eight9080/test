package com.example.designpatterns.chainofresponsability.approver;

public interface IExpenseApprover {

    ApprovalResponse approveExpense(IExpenseReport expenseReport);

}