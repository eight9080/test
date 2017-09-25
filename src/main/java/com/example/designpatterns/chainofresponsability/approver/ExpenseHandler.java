package com.example.designpatterns.chainofresponsability.approver;

public class ExpenseHandler implements IExpenseHandler {

    private  IExpenseApprover approver;
    private  IExpenseHandler next;

    public ExpenseHandler(IExpenseApprover approver) {
        this.approver = approver;
        this.next = EndOfChainExpenseHandler.getInstance();
    }

    @Override
    public ApprovalResponse approve(IExpenseReport expenseReport) {
        final ApprovalResponse approver = this.approver.approveExpense(expenseReport);
        if(approver == ApprovalResponse.BEYOND_APPROVAL_LIMIT){
            return next.approve(expenseReport);
        }

        return approver;
    }

    @Override
    public void registerNext(IExpenseHandler next) {
        this.next = next;
    }
}
