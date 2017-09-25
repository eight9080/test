package com.example.designpatterns.factory.factory4;

public class VisaValidator extends Validator {
    @Override
    public boolean isValid(CreditCard creditCard) {
        return false;
    }
}
