package com.example.designpatterns.rules.greed;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ThreePairsRule implements IRule {
    @Override
    public ScoreResult eval(int[] dice) {
        if(dice.length>=6){
            final Map<Integer, Integer> numberByOccurances = Arrays.stream(dice).boxed().collect(
                    Collectors.toMap(val -> val,
                            (val) -> 1,
                            (val1, val2) -> ++val1));


                 final long pairCount = numberByOccurances.values().stream()
                         .filter(val -> val >= 2)
                         .filter(val -> val%2==0)
                         .map(val -> val/2).mapToInt(Integer::intValue).sum();
                 if(pairCount>=3){
                     return new ScoreResult.Builder()
                             .diceUsed(dice).score(800)
                             .ruleUsed(this).build();
                 }

        }

        return ScoreResult.emptyScore();
    }
}
