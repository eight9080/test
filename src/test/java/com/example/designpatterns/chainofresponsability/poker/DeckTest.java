package com.example.designpatterns.chainofresponsability.poker;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static com.example.designpatterns.chainofresponsability.poker.Hand.HandRanking.values;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void testDeal() throws Exception {

        final Deck deck = new Deck();
        deck.shuffle();

        final List<Hand> hands = IntStream.range(0, 10).collect(
                () -> new ArrayList<Hand>(),
                (list, i) -> list.add(new Hand()),
                (list1, list2) -> list1.addAll(list2));

        IntStream.range(0,5).forEach(
                (a) -> {
                  hands.forEach(hand -> hand.add(deck.deal()));
                }
        );

        hands.forEach((hand) -> System.out.println(hand.getRank() +" "+ hand));

        assertThat(hands, notNullValue());
        final Hand.HandRanking rankZero = hands.get(0).getRank();
        assertThat(rankZero, notNullValue());

    }
}