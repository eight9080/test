package com.example.designpatterns.chainofresponsability.approver;

import java.math.BigDecimal;

public class Employee implements IExpenseApprover{

    private String name;
    private BigDecimal approvalLimit;

    public Employee(String name, BigDecimal approvalLimit) {
        this.name = name;
        this.approvalLimit = approvalLimit;
    }

    public String getName() {
        return name;
    }

    @Override
    public ApprovalResponse approveExpense(IExpenseReport expenseReport) {
        return expenseReport.getTotal().compareTo(approvalLimit) > 0 ? ApprovalResponse.BEYOND_APPROVAL_LIMIT
                : ApprovalResponse.APPROVED;
    }
}
