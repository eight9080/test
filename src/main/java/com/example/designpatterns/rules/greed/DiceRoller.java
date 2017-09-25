package com.example.designpatterns.rules.greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiceRoller {

    private RuleSet ruleSet = new RuleSet();


    public DiceRoller(boolean useAllRules) {
        ruleSet.addRule(new SingleDieRule(1, 100));
        ruleSet.addRule(new SingleDieRule(5, 50));
        ruleSet.addRule(new SetOfDiceRule(3, 1, 1000));
        IntStream.rangeClosed(2, 6).forEach(val -> {
            ruleSet.addRule(new SetOfDiceRule(3, val, val * 100));
        });
        if (useAllRules) {
            ruleSet.addRule(new SetOfDiceRule(4, 1, 2000));
            ruleSet.addRule(new SetOfDiceRule(5, 1, 4000));
            ruleSet.addRule(new SetOfDiceRule(6, 1, 8000));
            ruleSet.addRule(new StrainghtRule());
            ruleSet.addRule(new ThreePairsRule());
            IntStream.rangeClosed(2, 6).forEach(val -> {
                ruleSet.addRule(new SetOfDiceRule(4, val, val * 200));
                ruleSet.addRule(new SetOfDiceRule(5, val, val * 400));
                ruleSet.addRule(new SetOfDiceRule(6, val, val * 800));
            });
        }
    }

    public void addScoringRule(IRule rule){
        ruleSet.addRule(rule);
    }

    public int score(int[] roles) {
        int score = 0;
        IRule bestRule = ruleSet.bestRule(roles);
        final List<Integer> remainingDice = Arrays.stream(roles).boxed().collect(Collectors.toList());
        while (bestRule != null) {
            final ScoreResult scoreResult = bestRule.eval(remainingDice.stream().mapToInt(Integer::intValue).toArray());
            final int[] diceUsed = scoreResult.getDiceUsed();
            Arrays.stream(diceUsed).boxed().forEach(remainingDice::remove);
            score += scoreResult.getScore();
            bestRule = ruleSet.bestRule(remainingDice.stream().mapToInt(Integer::intValue).toArray());
        }

        return score;
    }

}
