package com.example.designpatterns.rules.greed;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StrainghtRule implements IRule {
    @Override
    public ScoreResult eval(int[] dice) {
        if(dice.length==6) {
            final long distinctNumbers = Arrays.stream(dice).distinct().count();
            if (distinctNumbers == dice.length) {
                return new ScoreResult.Builder()
                        .diceUsed(dice).score(1200)
                        .ruleUsed(this).build();
            }
        }
        return ScoreResult.emptyScore();
    }
}
