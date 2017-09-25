package com.example.designpatterns.chainofresponsability.approver;

public class EndOfChainExpenseHandler implements IExpenseHandler {


    private static EndOfChainExpenseHandler instance = new EndOfChainExpenseHandler();

    public static EndOfChainExpenseHandler getInstance(){
        return instance;
    }

    @Override
    public ApprovalResponse approve(IExpenseReport expenseReport) {
        return ApprovalResponse.DENIED;
    }

    @Override
    public void registerNext(IExpenseHandler next) {
        throw new UnsupportedOperationException("end of chain");
    }
}
