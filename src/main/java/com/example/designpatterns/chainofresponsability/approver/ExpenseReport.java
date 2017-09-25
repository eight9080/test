package com.example.designpatterns.chainofresponsability.approver;

import java.math.BigDecimal;

public class ExpenseReport implements IExpenseReport {

    private BigDecimal total;

    public ExpenseReport(BigDecimal total) {
        this.total = total;
    }

    @Override
    public BigDecimal getTotal() {
        return total;
    }

}