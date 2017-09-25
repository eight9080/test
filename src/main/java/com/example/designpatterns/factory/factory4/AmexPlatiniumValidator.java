package com.example.designpatterns.factory.factory4;

public class AmexPlatiniumValidator extends Validator {
    @Override
    public boolean isValid(CreditCard creditCard) {
        return false;
    }
}
