package com.example.designpatterns.chainofresponsability.poker.categorizer;

import com.example.designpatterns.chainofresponsability.poker.Card;
import com.example.designpatterns.chainofresponsability.poker.Hand;

import java.util.Map;

public class TwoPairCatagorizer extends HandCategorizer {
    @Override
    public Hand.HandRanking categorize(Hand hand) {

        final Map<Card.Value, Integer> cardsByValueOcCurences = getCardsByValueOccurences(hand.getCards());

        final long noPairs = cardsByValueOcCurences.entrySet().stream()
                .filter(entry -> entry.getValue() == 2).count();
        if(noPairs==2){
            return Hand.HandRanking.Pair;
        }

        return next.categorize(hand);
    }
}
