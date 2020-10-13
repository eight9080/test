package com.example.concurent.se;

public class ThreadA {public static void main(String [] args) {
    ThreadB b = new ThreadB();
    b.start();
    synchronized(b) {
        try {
            System.out.println("Waiting for b to complete... thread "+ Thread.currentThread().getName());
            b.wait();
        } catch (InterruptedException e) {}
        System.out.println("Total is: " + b.total);
    }
}
}

class ThreadB extends Thread {
    int total;

    public void run() {
        synchronized(this) {
            for(int i = 0; i < 100; i++) {
                total += i;
                System.out.println("Thread B "+ currentThread().getName()+" i " + i);
            }
            System.out.println("notify ");
            notify();
        }
    }
}
