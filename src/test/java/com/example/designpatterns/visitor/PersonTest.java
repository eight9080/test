package com.example.designpatterns.visitor;

import com.example.designpatterns.visitor.bank.*;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void calculateNetWorth() throws Exception {
        final Person person = new Person();
        person.getAssets().add(new BankAccount(1000, 0.01));
        person.getAssets().add(new BankAccount(2000, 0.02));
        person.getAssets().add(new RealEstate(79000, 500));
        person.getAssets().add(new Loan(40000, 40));

        final NetWorthVisitor netWorthVisitor = new NetWorthVisitor();
        person.accept(netWorthVisitor);

        assertThat(netWorthVisitor.getTotal(), is(42000));

        final IncomeVisitor incomeVisitor = new IncomeVisitor();
        person.accept(incomeVisitor);
        assertThat(incomeVisitor.getAmount(), is(510.0));

    }
}