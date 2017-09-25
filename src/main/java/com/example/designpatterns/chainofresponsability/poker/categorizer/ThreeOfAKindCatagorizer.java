package com.example.designpatterns.chainofresponsability.poker.categorizer;

import com.example.designpatterns.chainofresponsability.poker.Hand;

public class ThreeOfAKindCatagorizer extends HandCategorizer {
    @Override
    public Hand.HandRanking categorize(Hand hand) {

        if(hasNoOfKind(3, hand)){
            return Hand.HandRanking.ThreeOfAKind;
        }

        return next.categorize(hand);
    }
}