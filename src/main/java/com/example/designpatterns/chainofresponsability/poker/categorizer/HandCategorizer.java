package com.example.designpatterns.chainofresponsability.poker.categorizer;

import com.example.designpatterns.chainofresponsability.poker.Card;
import com.example.designpatterns.chainofresponsability.poker.Hand;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class HandCategorizer {

    protected HandCategorizer next;

    public HandCategorizer registerNext(HandCategorizer next){
        this.next = next;
        return next;
    }

    public abstract Hand.HandRanking categorize(Hand hand);

    protected boolean hasFlush(Hand hand){
        final Set<Card.Suit> suits = hand.getCards().stream().map(card -> card.getSuit()).collect(Collectors.toSet());
        return suits.size()==1 ? true: false;
    }

    protected boolean hasStraight(Hand hand){
        final List<Integer> values = hand.getCards().stream()
                .map(card -> card.getValue().ordinal())
                .sorted()
                .collect(Collectors.toList());
        int expectedValue = values.get(0);

        for (Integer val: values) {
            if (val != expectedValue) {
                return false;
            }
            expectedValue++;
        }
        return  true;
    }

    protected boolean hasNoOfKind(int n, Hand hand){
        final List<Card> cards = hand.getCards();

        final Map<Card.Value, Integer> cardsByValueOccurences = getCardsByValueOccurences(cards);

        final Optional<Map.Entry<Card.Value, Integer>> valueFoundNTimes =
                cardsByValueOccurences.entrySet().stream()
                        .filter(entry -> entry.getValue() == n)
                        .findAny();
        return valueFoundNTimes.isPresent()? true : false;
    }

    protected Map<Card.Value, Integer> getCardsByValueOccurences(List<Card> cards) {
        return cards.stream().collect(Collectors.toMap(
                    card -> card.getValue(),
                    card -> 1,
                    (occurrence, increment) -> occurrence + increment
            ));
    }

}