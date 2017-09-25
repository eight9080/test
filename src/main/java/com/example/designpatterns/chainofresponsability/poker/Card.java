package com.example.designpatterns.chainofresponsability.poker;


public class Card {

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return suiteToString() + valueToString();
    }

    private String suiteToString(){
        switch (suit)
        {
            case Club:
                return "C";
            case Heart:
                return "H";
            case Diamond:
                return "D";
            case Spade:
                return "S";
            default:
                throw new IllegalArgumentException("Not valid suit "+ suit);
        }
    }

    private String valueToString()
    {
        switch (value)
        {
            case Two:
                return "2";
            case Three:
                return "3";
            case Four:
                return "4";
            case Five:
                return "5";
            case Six:
                return "6";
            case Seven:
                return "7";
            case Eight:
                return "8";
            case Nine:
                return "9";
            case Ten:
                return "10";
            case Jack:
                return "J";
            case Queen:
                return "Q";
            case King:
                return "K";
            case Ace:
                return "A";
            default:
                throw new IllegalArgumentException("Not valid value" + value);

        }
    }

    public enum Suit
    {
        Diamond,
        Club,
        Heart,
        Spade,
    }

    public enum Value
    {
        Two,
        Three,
        Four,
        Five,
        Six,
        Seven,
        Eight,
        Nine,
        Ten,
        Jack,
        Queen,
        King,
        Ace,
    }
}
