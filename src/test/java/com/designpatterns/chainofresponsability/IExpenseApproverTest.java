package com.designpatterns.chainofresponsability;

import com.example.designpatterns.chainofresponsability.approver.Employee;
import com.example.designpatterns.chainofresponsability.approver.ExpenseReport;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class IExpenseApproverTest {

    @Test
    public void approveExpense(){
        final List<Employee> managers = Arrays.asList(
                new Employee("William W", BigDecimal.ZERO),
                new Employee("Mary W", new BigDecimal("1000")),
                new Employee("Victor W", new BigDecimal("5000")),
                new Employee("Paul W", new BigDecimal("20000"))
        );

        final ExpenseReport expenseReport = new ExpenseReport(new BigDecimal("500"));



    }

}