package com.example.designpatterns.rules;

public class FirstTimeCustomerRule implements IDiscountRule {
    @Override
    public double calculateCustomerDiscount(Customer customer) {
        if (customer.getDateOfFirstPurchase()==null){
            // first time purchase discount of 15%
            return 0.15D;
        }
        return 0;
    }
}
