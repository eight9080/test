package com.example.designpatterns.rules;

public class VeteranRule implements IDiscountRule {
    @Override
    public double calculateCustomerDiscount(Customer customer) {
        if (customer.isVeteran()){
            // veterans get 10%
            return 0.10D;
        }
        return 0;
    }
}
