package com.designpatterns.chainofresponsability;

import com.example.designpatterns.chainofresponsability.approver.*;
import com.example.designpatterns.exception.BusinessException;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.example.designpatterns.exception.BusinessException.BusinessReason.REPORT_NOT_APPROVED;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class ApproverExpensesServiceTest {

    private final List<IExpenseApprover> managers = Arrays.asList(
            new Employee("William W", BigDecimal.ZERO),
            new Employee("Mary W", new BigDecimal("1000")),
            new Employee("Victor W", new BigDecimal("5000")),
            new Employee("Paul W", new BigDecimal("20000"))
    );

    @Test
    public void approveExpense() throws Exception {

        final ExpenseReport expenseReport = new ExpenseReport(new BigDecimal("500"));

        final IExpenseApprover expenseApprover = ApproverExpensesService.approveExpense(expenseReport, managers);
        assertThat(expenseApprover, notNullValue());
        assertThat(expenseApprover, hasProperty("name", is("Mary W")));
    }

    @Test
    public void approveExpense_reportNotApproved()  {

        final ExpenseReport expenseReport = new ExpenseReport(new BigDecimal("50000000"));

        try {
            ApproverExpensesService.approveExpense(expenseReport, managers);
            fail("report should not have approver");
        } catch (BusinessException e) {
            assertThat(e.getBusinessReason(), is(REPORT_NOT_APPROVED) );
        }

    }

    @Test
    public  void approveExpense_approved(){
        final ExpenseHandler firstApprover = getExpenseHandler();

        final ExpenseReport expenseReport = new ExpenseReport(new BigDecimal("500"));

        final ApprovalResponse approve = firstApprover.approve(expenseReport);
        assertThat(approve, is(ApprovalResponse.APPROVED));

    }

    @Test
    public  void approveExpense_notApproved(){
        final ExpenseHandler firstApprover = getExpenseHandler();

        final ExpenseReport expenseReport = new ExpenseReport(new BigDecimal("500000000"));

        final ApprovalResponse approve = firstApprover.approve(expenseReport);

        assertThat(approve, is(ApprovalResponse.DENIED));
    }

    private ExpenseHandler getExpenseHandler() {
        final ExpenseHandler firstApprover = new ExpenseHandler(new Employee("William W", BigDecimal.ZERO));
        final ExpenseHandler secondApprover = new ExpenseHandler(new Employee("Mary W", new BigDecimal("1000")));
        final ExpenseHandler thirdApprover = new ExpenseHandler(new Employee("Victor W", new BigDecimal("5000")));
        final ExpenseHandler forthApprover = new ExpenseHandler(new Employee("Paul W", new BigDecimal("20000")));
        firstApprover.registerNext(secondApprover);
        secondApprover.registerNext(thirdApprover);
        thirdApprover.registerNext(forthApprover);
        return firstApprover;
    }

}