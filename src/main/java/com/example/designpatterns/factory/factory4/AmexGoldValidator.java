package com.example.designpatterns.factory.factory4;

public class AmexGoldValidator extends Validator {
    @Override
    public boolean isValid(CreditCard creditCard) {
        return false;
    }
}
