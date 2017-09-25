package com.example.designpatterns.chainofresponsability.poker.categorizer;

import com.example.designpatterns.chainofresponsability.poker.Hand;

public class HighCardCatagorizer extends HandCategorizer {
    @Override
    public Hand.HandRanking categorize(Hand hand) {
        return Hand.HandRanking.HighCard;
    }
}
