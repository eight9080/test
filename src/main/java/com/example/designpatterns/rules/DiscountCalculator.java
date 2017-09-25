package com.example.designpatterns.rules;

import java.util.ArrayList;
import java.util.List;

public class DiscountCalculator {

    private List<IDiscountRule> rules = new ArrayList<>();

    public DiscountCalculator() {
        rules.add(new SeniorRule());
        rules.add(new BirthdayDiscountRule());
        rules.add(new VeteranRule());
        rules.add(new LoyalCustomerRule(1, 0.10D));
        rules.add(new LoyalCustomerRule(5, 0.12D));
        rules.add(new LoyalCustomerRule(10, 0.20D));
        rules.add(new FirstTimeCustomerRule());
    }

    public double calculateDiscountPercentage(Customer customer){
        double discount = 0;

        for (IDiscountRule rule: rules) {
            discount = Math.max(rule.calculateCustomerDiscount(customer), discount);
        }
        return discount;
    }
}