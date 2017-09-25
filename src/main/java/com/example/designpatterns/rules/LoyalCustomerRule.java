package com.example.designpatterns.rules;

import java.time.LocalDate;

public class LoyalCustomerRule implements IDiscountRule {
     private int yearsAsCustomer;
     private double discount;

    public LoyalCustomerRule(int yearsAsCustomer, double discount) {
        this.yearsAsCustomer = yearsAsCustomer;
        this.discount = discount;
    }

    @Override
    public double calculateCustomerDiscount(Customer customer) {
        if(customer.getDateOfFirstPurchase()!=null) {
            final LocalDate calculatedDateFromFirstPurchase = customer.getDateOfFirstPurchase().plusYears(yearsAsCustomer);
            if (calculatedDateFromFirstPurchase.equals(LocalDate.now()) ||
                    calculatedDateFromFirstPurchase.isBefore(LocalDate.now())) {
                final BirthdayDiscountRule birthdayDiscountRule = new BirthdayDiscountRule();
                final double birthDayDiscount = birthdayDiscountRule.calculateCustomerDiscount(customer);
                return discount + birthDayDiscount;
            }
        }

        return 0;
    }
}