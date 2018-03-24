package com.example.oodesign.twitter;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TwitterTest {

    @Test
    public void postTweet() {
        Twitter obj = new Twitter();
        obj.postTweet(2, 10);
        obj.postTweet(2, 11);
        List<Integer> param_2 = obj.getNewsFeed(1);
        Assertions.assertThat(param_2)
                .isEmpty();

        obj.follow(1, 2);
        param_2 = obj.getNewsFeed(1);
        Assertions.assertThat(param_2)
                .contains(11,10);

        obj.unfollow(1, 2);
        param_2 = obj.getNewsFeed(1);
        Assertions.assertThat(param_2)
                .isEmpty();

    }


    @Test
    public void postTweet2() {
        Twitter obj = new Twitter();
        obj.postTweet(1, 4);
        obj.postTweet(2, 5);
        obj.unfollow(1, 2);
        obj.follow(1, 2);
        List<Integer> param_2 = obj.getNewsFeed(1);
        Assertions.assertThat(param_2)
                .contains(5,4);

    }
}