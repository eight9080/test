package com.example.designpatterns.factory.factory4;

public class AbstractFactoryDemo {

    public static void main(String[] args) {
        final CreditCardFactory creditCardFactory = CreditCardFactory.getCreditCardFactory(775);
        final CreditCard creditCard = creditCardFactory.getCreditCard(CardType.PLATINIUM);
        System.out.println(creditCard);

        final CreditCardFactory creditCardFactory1 = CreditCardFactory.getCreditCardFactory(600);
        final CreditCard creditCard1 = creditCardFactory1.getCreditCard(CardType.GOLD);
        System.out.println(creditCard1);
    }
}
