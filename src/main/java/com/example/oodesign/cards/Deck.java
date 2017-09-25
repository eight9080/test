package com.example.oodesign.cards;

import com.example.AssortedMethods;

import java.util.ArrayList;

public class Deck<T extends Card> {
    private ArrayList<T> cards;
    private int dealtIndex = 0;

    public Deck() {
    }

    public void setDeckOfCards(ArrayList<T> cards) {
        this.cards = cards;
    }

    public void shuffle(){
        for (int i = 0; i < cards.size(); i++) {
            final int j = AssortedMethods.randomIntInRange(i, cards.size() - i - 1);
            T card1 = cards.get(i);
            T card2 = cards.get(j);
            cards.set(i, card2);
            cards.set(j, card1);
        }
    }

    public int remaningCards(){
        return cards.size() - dealtIndex;
    }

    public T dealCard(){
        if(remaningCards() == 0){
            return null;
        }

        final T card = cards.get(dealtIndex);
        card.markUnavailable();
        dealtIndex++;
        return card;
    }

    public T[] dealHand(int number){
        if(remaningCards()<number){
            return null;
        }
        T[] hand = (T[])new Card[number];
        int count   = 0;
        while (count<number){
            final T card = dealCard();
            if(card!=null){
                hand[count]= card;
                count++;
            }
        }
        return hand;
    }

    public void print() {
        for (Card card : cards) {
            card.print();
        }
    }
}
