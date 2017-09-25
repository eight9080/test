package com.example.designpatterns.rules.greed;

import java.util.Arrays;

public class SingleDieRule implements IRule{
    private int dieValue;
    private int score;

    public SingleDieRule(int dieValue, int score) {
        this.dieValue = dieValue;
        this.score = score;
    }

    @Override
    public ScoreResult eval(int[] dice) {
        final int[] diceUsed = Arrays.stream(dice).filter(val -> val == dieValue).toArray();

        return new ScoreResult.Builder()
                .diceUsed(diceUsed).score(diceUsed.length * score)
                .ruleUsed(this).build();
    }
}
