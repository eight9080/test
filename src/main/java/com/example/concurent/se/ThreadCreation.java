package com.example.concurent.se;

import java.util.concurrent.locks.LockSupport;

public class ThreadCreation {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            final Thread thread = new Thread(() -> {
                LockSupport.park();
                System.out.println("Thread "+ Thread.currentThread().getName());
            }, "grumpy");
            thread.start();
            Thread.sleep(100);
        }
    }
}
