package com.example.designpatterns.chainofresponsability.poker.categorizer;

import com.example.designpatterns.chainofresponsability.poker.Hand;


public class FlushCatagorizer extends HandCategorizer {
    @Override
    public Hand.HandRanking categorize(Hand hand) {

        if(hasFlush(hand)){
            return Hand.HandRanking.Flush;
        }

        return next.categorize(hand);
    }
}
