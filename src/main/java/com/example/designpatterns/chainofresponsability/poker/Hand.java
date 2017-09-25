package com.example.designpatterns.chainofresponsability.poker;

import com.example.designpatterns.exception.BusinessException;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private static final int MAX_NO_CARDS = 5;

    private final List<Card> cards = new ArrayList<>();
    private HandRanking rank = HandRanking.Unknown;

    public void add(Card card) throws BusinessException {
        if(cards.size()==MAX_NO_CARDS){
            throw new BusinessException(BusinessException.BusinessReason.MAX_NO_CARDS);
        }
        cards.add(card);
        if(cards.size()==MAX_NO_CARDS){
            rank = HandCategorizerChain.getRank(this);
        }
    }

    public Card highCard() throws BusinessException {
        if(cards.size()==0){
            throw new BusinessException(BusinessException.BusinessReason.NO_CARDS);
        }
        return cards.get(cards.size()-1);
    }

    public List<Card> getCards() {
        return cards;
    }

    public HandRanking getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return cards.stream().collect
                (() -> new StringBuilder("Hand: "),
                        (sb, card) -> sb.append(card),
                        (sb1, sb2) -> sb1.append(sb2)).toString();
    }

    public enum HandRanking{
        Unknown,
        HighCard,
        Pair,
        TwoPair,
        ThreeOfAKind,
        Straight,
        Flush,
        FullHouse,
        FourOfAKind,
        StraightFlush,
        RoyalFlush,
    }
}
