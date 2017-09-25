package com.example.designpatterns.chainofresponsability.poker.categorizer;

import com.example.designpatterns.chainofresponsability.poker.Hand;

public class PairCatagorizer extends HandCategorizer {
    @Override
    public Hand.HandRanking categorize(Hand hand) {

        if(hasNoOfKind(2, hand)){
            return Hand.HandRanking.Pair;
        }

        return next.categorize(hand);
    }
}
