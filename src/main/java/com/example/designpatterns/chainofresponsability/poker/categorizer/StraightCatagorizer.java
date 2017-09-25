package com.example.designpatterns.chainofresponsability.poker.categorizer;

import com.example.designpatterns.chainofresponsability.poker.Hand;

public class StraightCatagorizer extends HandCategorizer {
    @Override
    public Hand.HandRanking categorize(Hand hand) {
        if (hasStraight(hand)) {
            return Hand.HandRanking.Straight;
        }
        return next.categorize(hand);
    }
}