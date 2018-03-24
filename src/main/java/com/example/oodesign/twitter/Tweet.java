package com.example.oodesign.twitter;

import java.time.LocalDateTime;

public class Tweet {

    public int id;
    public LocalDateTime time;
    public int countX;
    public Tweet next;

    public Tweet(int id, int count){
        this.id = id;
        time = LocalDateTime.now();
        countX=count;
        next=null;
    }
}
