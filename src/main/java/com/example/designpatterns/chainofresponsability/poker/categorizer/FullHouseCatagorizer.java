package com.example.designpatterns.chainofresponsability.poker.categorizer;

import com.example.designpatterns.chainofresponsability.poker.Card;
import com.example.designpatterns.chainofresponsability.poker.Hand;

import java.util.Map;

public class FullHouseCatagorizer extends HandCategorizer {
    @Override
    public Hand.HandRanking categorize(Hand hand) {
        final Map<Card.Value, Integer> cardsByValueOccurences = getCardsByValueOccurences(hand.getCards());

        if(cardsByValueOccurences.size()==2){
            if( cardsByValueOccurences.values().contains(2)
                    && cardsByValueOccurences.values().contains(3)){
                return Hand.HandRanking.FullHouse;
            }
        }

        return next.categorize(hand);
    }
}
