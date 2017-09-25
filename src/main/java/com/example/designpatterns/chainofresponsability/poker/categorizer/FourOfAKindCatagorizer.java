package com.example.designpatterns.chainofresponsability.poker.categorizer;

import com.example.designpatterns.chainofresponsability.poker.Hand;

public class FourOfAKindCatagorizer extends HandCategorizer {
    @Override
    public Hand.HandRanking categorize(Hand hand) {
        if(hasNoOfKind(4, hand)){
            return Hand.HandRanking.FourOfAKind;
        }
        return next.categorize(hand);
    }
}
