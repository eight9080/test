package com.example.designpatterns.factory.factory4;

public class AmexFactory extends CreditCardFactory {

    public CreditCard getCreditCard(CardType cardType){
        switch (cardType){
            case GOLD: return new AmexGoldCreditCard();
            case PLATINIUM: return new AmexPlatiniumCreditCard();
        }
        return null;
    }

    public Validator getValidator(CardType cardType){
        switch (cardType){
            case GOLD: return new AmexGoldValidator();
            case PLATINIUM: return new AmexPlatiniumValidator();
        }
        return null;
    }
}