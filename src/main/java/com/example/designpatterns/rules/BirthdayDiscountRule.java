package com.example.designpatterns.rules;

import java.time.LocalDate;

public class BirthdayDiscountRule implements IDiscountRule {
    @Override
    public double calculateCustomerDiscount(Customer customer) {
        if(customer.getDateOfBirth()!=null) {
            if (customer.getDateOfBirth().getMonth() == LocalDate.now().getMonth()
                    && customer.getDateOfBirth().getDayOfMonth() == LocalDate.now().getDayOfMonth()) {
                // birthday 10%
                return 0.10D;
            }
        }
        return 0;
    }
}
