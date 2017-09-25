package com.example.designpatterns.rules;

import java.time.LocalDate;

public class SeniorRule implements IDiscountRule {
    @Override
    public double calculateCustomerDiscount(Customer customer) {
        if (customer.getDateOfBirth().isBefore(LocalDate.now().plusYears(-65))){
            // senior discount 5%
            return  0.05D;
        }
        return 0;
    }
}
