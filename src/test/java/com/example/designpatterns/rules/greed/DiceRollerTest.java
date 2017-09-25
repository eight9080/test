package com.example.designpatterns.rules.greed;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DiceRollerTest {

    private DiceRoller _greedGame =  new DiceRoller(true);

    @Test
    public void noSetsResultsInZeroScore() throws Exception {
        int score = _greedGame.score(new int[] { 2, 3, 4, 3, 2 });
        assertThat(score, is(0));
    }

    @Test
    public void OneIsWorth100()
    {
        int score = _greedGame.score(new int[] { 1 });
        assertThat(score, is(100));
    }

    @Test
    public void TwoOnesAreWorth200()
    {
        int score = _greedGame.score(new int[] { 1, 1 });
        assertThat(score, is(200));
    }

    @Test
    public void ThreeOnesAreWorth1000()
    {
        int score = _greedGame.score(new int[] { 1, 1, 1 });
        assertThat(score, is(1000));
    }

    @Test
    public void FourOnesAreWorth1100()
    {
        DiceRoller game = new DiceRoller(false);
        int score = game.score(new int[] { 1, 1, 1, 1 });
        assertThat(score, is(1100));
    }

    @Test
    public void OneFiveIsWorth50()
    {
        int score = _greedGame.score(new int[] { 5 });
        assertThat(score, is(50));
    }

    @Test
    public void ThreeFivesAreWorth500()
    {
        int score = _greedGame.score(new int[] { 5, 5, 5 });
        assertThat(score, is(500));
    }

    @Test
    public void ThreeTwosAreWorth200()
    {
        int score = _greedGame.score(new int[] { 2, 2, 2 });
        assertThat(score, is(200));
    }

    @Test
    public void GivenAssertionsAreCorrect()
    {
        DiceRoller game = new DiceRoller(false);
        assertThat(game.score(new int[] { 1, 1, 1, 5, 1 }), is(1150));
        assertThat(game.score(new int[] { 2, 3, 4, 6, 2 }), is(0));
        assertThat(game.score(new int[] { 3, 4, 5, 3, 3  }), is(350));
        assertThat(game.score(new int[] { 1, 5, 1, 2, 4 }), is(250));
    }

    @Test
    public void ScoreResultForOneIs100()
    {
        SingleDieRule rule = new SingleDieRule(1, 100);
        ScoreResult result = rule.eval(new int[] { 1 });
        assertThat(result.getDiceUsed().length, is(1));
        assertThat(result.getDiceUsed()[0], is(1));
        assertThat(result.getScore(), is(100));
    }

    @Test
    public void ScoreResultForTwoOnesIs200(){

        SingleDieRule rule = new SingleDieRule(1, 100);
        ScoreResult result = rule.eval(new int[] { 1,1 });
        assertThat(result.getDiceUsed().length, is(2));
        assertThat(result.getDiceUsed()[0], is(1));
        assertThat(result.getDiceUsed()[1], is(1));
        assertThat(result.getScore(), is(200));
    }

    @Test
    public void ShouldScore2000With4Ones()
    {
        assertThat(_greedGame.score(new int[] { 1, 1, 1, 1, 4, 6 }), is(2000));
    }
    @Test
    public void ShouldScore8000With6Ones()
    {
        assertThat(_greedGame.score(new int[] { 1, 1, 1, 1, 1, 1  }), is(8000));
    }
    @Test
    public void ShouldScore1200WithStraight()
    {
        assertThat(_greedGame.score(new int[] { 1, 2, 3, 4, 5, 6 }), is(1200));
    }

    @Test
    public void ShouldScore800With3Pairs()
    {
        assertThat(_greedGame.score(new int[] { 1, 1, 2, 2, 6, 6 }), is(800));
    }

    @Test
    public void ShouldScore800With3PairsAnd6TwosBasicRulesAnd3PairsRuleOnly()
    {
        DiceRoller game = new DiceRoller(false);
        game.addScoringRule(new ThreePairsRule());
        assertThat(game.score(new int[] { 2,2,2,2,2,2 }), is(800));
        assertThat(game.score(new int[] { 2,2,1,1,2,2 }), is(800));
    }

}