package com.example.oodesign.twitter;

import java.util.HashSet;
import java.util.Set;

public class User {

    public int id;
    public Set<Integer> followedUsers;
    public Tweet lastTweet;

    public User(int id){
        this.id=id;
        followedUsers = new HashSet<>();
        follow(id); // first follow itself
        lastTweet = null;
    }

    public void follow(int id){
        followedUsers.add(id);
    }

    public void unfollow(int id){
        followedUsers.remove(id);
    }

    // everytime user post a new tweet, add it to the head of tweet list.
    public void post(int id, int count){
        Tweet t = new Tweet(id, count);
        t.next=lastTweet;
        lastTweet=t;
    }

}
