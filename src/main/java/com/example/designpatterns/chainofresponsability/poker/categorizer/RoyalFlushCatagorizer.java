package com.example.designpatterns.chainofresponsability.poker.categorizer;

import com.example.designpatterns.chainofresponsability.poker.Card;
import com.example.designpatterns.chainofresponsability.poker.Hand;

public class RoyalFlushCatagorizer extends HandCategorizer {


    @Override
    public Hand.HandRanking categorize(Hand hand) {

        if(hasFlush(hand) && hasStraight(hand) && hand.highCard().getValue()== Card.Value.Ace){
            return Hand.HandRanking.RoyalFlush;
        }
        return next.categorize(hand);
    }
}