package com.example.designpatterns.chainofresponsability.approver;

import com.example.designpatterns.exception.BusinessException;

import java.util.List;

import static com.example.designpatterns.exception.BusinessException.BusinessReason.REPORT_NOT_APPROVED;

public class ApproverExpensesService {

    public static IExpenseApprover approveExpense(IExpenseReport expenseReport,  List<IExpenseApprover> approvers) throws BusinessException {
        for (IExpenseApprover approver: approvers) {
            final ApprovalResponse approvalResponse = approver.approveExpense(expenseReport);
            if(approvalResponse!= ApprovalResponse.BEYOND_APPROVAL_LIMIT){
                return approver;
            }
        }
        throw new BusinessException(REPORT_NOT_APPROVED);
    }

    public static ApprovalResponse approveExpense(IExpenseReport expenseReport, IExpenseHandler approverHandlers) throws BusinessException {
        final ApprovalResponse approve = approverHandlers.approve(expenseReport);
        if(approve == ApprovalResponse.BEYOND_APPROVAL_LIMIT){
            throw new BusinessException(REPORT_NOT_APPROVED);
        }
        return approve;
    }
}
