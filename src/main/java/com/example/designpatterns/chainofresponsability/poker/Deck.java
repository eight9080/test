package com.example.designpatterns.chainofresponsability.poker;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.UUID.randomUUID;

public class Deck {

    private Queue<Card> cards = new LinkedList<>();


    public Deck() {
        for (Card.Suit suit: Card.Suit.values()) {
            for(Card.Value value: Card.Value.values()) {
                cards.add(new Card(suit, value));
            }
        }
    }

    public Card deal(){
        return cards.poll();
    }

    public void shuffle(){
        shuffle(7);
    }

    private void shuffle(int count){
        IntStream.range(0,count).forEach((a)-> {
            final PriorityQueue<Card> newCards = new PriorityQueue<>(this.cards.size(), Comparator.comparing((c1)-> randomUUID()));
            newCards.addAll(cards);
            this.cards = newCards;
        });

    }
}
