package com.example.designpatterns.rules.greed;

import java.util.Arrays;

public class SetOfDiceRule implements IRule{
    private int setSize;
    private int dieValue;
    private int score;

    public SetOfDiceRule(int setSize, int dieValue, int score) {
        this.setSize = setSize;
        this.dieValue = dieValue;
        this.score = score;
    }

    @Override
    public ScoreResult eval(int[] dice) {
        ScoreResult scoreResult = ScoreResult.emptyScore();
        final int[] diceUsed = Arrays.stream(dice).filter(val -> val == dieValue).limit(setSize).toArray();
        if(diceUsed.length==setSize){
            scoreResult = new ScoreResult.Builder()
                    .diceUsed(diceUsed).score(score)
                    .ruleUsed(this).build();
        }

        return scoreResult;
    }
}
