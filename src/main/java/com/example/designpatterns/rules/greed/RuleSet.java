package com.example.designpatterns.rules.greed;

import java.util.ArrayList;
import java.util.List;

public class RuleSet {

    private List<IRule> rules = new ArrayList<>();

    public IRule bestRule(int[] dice){
        if(dice==null || dice.length==0){
            return null;
        }
        ScoreResult bestScoreResult = ScoreResult.emptyScore();
        for(IRule rule: rules){
            final ScoreResult scoreResult = rule.eval(dice);
            if(bestScoreResult.getScore()<scoreResult.getScore()){
                bestScoreResult = scoreResult;
            }
        }
        return bestScoreResult.getRuleUsed();
    }

    public void addRule(IRule rule){
        rules.add(rule);
    }
}