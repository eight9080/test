package com.example.concurent.producerconsumer.lock;

public class Producer extends Thread {

    private ProducerConsumerImpl shared;

    public Producer(ProducerConsumerImpl sharedObject) {
        super("PRODUCER");
        this.shared = sharedObject;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.shared.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
