package com.example.designpatterns.rules.greed;

public class ScoreResult{

    private final static ScoreResult EMPTY_SCORE = new ScoreResult(0);


    private int[] diceUsed;
    private int score;
    private IRule ruleUsed;

    private ScoreResult(int[] diceUsed, int score, IRule ruleUsed) {
        this.diceUsed = diceUsed;
        this.score = score;
        this.ruleUsed = ruleUsed;
    }

    private ScoreResult(int score) {
        this.score = score;
    }

    public static ScoreResult emptyScore(){
            return EMPTY_SCORE;
    }

    public int[] getDiceUsed() {
        return diceUsed;
    }

    public int getScore() {
        return score;
    }

    public IRule getRuleUsed() {
        return ruleUsed;
    }

    public static class Builder{
        public int[] diceUsed;
        public int score;
        public IRule ruleUsed;

        public Builder diceUsed(int[] diceUsed){
            this.diceUsed = diceUsed;
            return this;
        }

        public Builder score(int score){
            this.score = score;
            return this;
        }

        public Builder ruleUsed(IRule rule){
            this.ruleUsed = rule;
            return this;
        }

        public ScoreResult build(){
            return new ScoreResult(this.diceUsed, this.score, this.ruleUsed );
        }
    }
}
