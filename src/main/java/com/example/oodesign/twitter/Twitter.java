package com.example.oodesign.twitter;

import java.util.*;

/**
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
 * <p>
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 */
public class Twitter {

    private final static int MAX_NEWS_FEED_ITEMS = 10;
    private static int COUNTER = 0;

    private Map<Integer, User> usersMap;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        usersMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!usersMap.containsKey(userId)) {
            User u = new User(userId);
            usersMap.put(userId, u);
        }
        usersMap.get(userId).post(tweetId, COUNTER++);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        if(!usersMap.containsKey(userId)){
            return Collections.emptyList();
        }

        final Set<Integer> followedUsers = usersMap.get(userId).followedUsers;
//        final PriorityQueue<Tweet> tweets = new PriorityQueue<>((a, b) -> b.time.compareTo(a.time));
        final PriorityQueue<Tweet> tweets = new PriorityQueue<>((a, b) -> b.countX-a.countX);

        for (Integer userFolloweeId : followedUsers) {
            final User user = usersMap.get(userFolloweeId);
            if(user!=null){
                final Tweet lastTweet = user.lastTweet;
                if(lastTweet!=null){
                    tweets.add(lastTweet);
                }
            }
        }


        List<Integer> newsFeed = new LinkedList<>();

        int countTweets=0;
        while(!tweets.isEmpty() && countTweets<MAX_NEWS_FEED_ITEMS){
            Tweet t = tweets.poll();
            newsFeed.add(t.id);
            countTweets++;
            if(t.next!=null) {
                tweets.add(t.next);
            }
        }

        return newsFeed;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        usersMap.putIfAbsent(followerId, new User(followerId));
        usersMap.putIfAbsent(followeeId, new User(followeeId));
        usersMap.get(followerId).follow(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if(followeeId!=followerId && usersMap.containsKey(followerId)){
            usersMap.get(followerId).unfollow(followeeId);
        }
    }
}
