package com.example.designpatterns.factory.factory4;

public class VisaFactory extends CreditCardFactory {

    public CreditCard getCreditCard(CardType cardType){
        switch (cardType){
            case GOLD: return new VisaGoldCreditCard();
            case PLATINIUM: return new VisaBlackCreditCard();
        }
        return null;
    }

    public Validator getValidator(CardType cardType){
        return new VisaValidator();
    }
}