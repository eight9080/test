package com.example.designpatterns.chainofresponsability.poker;

import com.example.designpatterns.chainofresponsability.poker.categorizer.*;

public class HandCategorizerChain {

    private static final HandCategorizerChain instance = new HandCategorizerChain();

    private final HandCategorizer head;


    private HandCategorizerChain() {
        head = new RoyalFlushCatagorizer();
        head.registerNext(new StraightFlushCatagorizer())
                .registerNext(new FourOfAKindCatagorizer())
                .registerNext(new FullHouseCatagorizer())
                .registerNext(new FlushCatagorizer())
                .registerNext(new StraightCatagorizer())
                .registerNext(new ThreeOfAKindCatagorizer())
                .registerNext(new TwoPairCatagorizer())
                .registerNext(new PairCatagorizer())
                .registerNext(new HighCardCatagorizer());
    }

    public static Hand.HandRanking getRank(Hand hand){
        return instance.head.categorize(hand);
    }

}
