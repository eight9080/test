package com.example.designpatterns.chainofresponsability.poker.categorizer;

import com.example.designpatterns.chainofresponsability.poker.Hand;

public class StraightFlushCatagorizer extends HandCategorizer {
    @Override
    public Hand.HandRanking categorize(Hand hand) {
        if(hasFlush(hand) && hasStraight(hand)){
            return Hand.HandRanking.StraightFlush;
        }
        return next.categorize(hand);
    }
}
