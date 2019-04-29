package com.example.concurent.producerconsumer.lock;

public class ProducerConsumerSolutionUsingLock {

    public static void main(String[] args) {
        // Object on which producer and consumer thread will operate
        ProducerConsumerImpl sharedObject = new ProducerConsumerImpl();
        // creating producer and consumer threads
        Producer p1 = new Producer(sharedObject);
        Consumer c = new Consumer(sharedObject);
        // starting producer and consumer threads
        p1.start();
        c.start();
    }
}
