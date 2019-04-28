package com.example.concurent.producerconsumer;

public class Consumer extends Thread {

    private ProducerConsumerImpl shared;
    private boolean stop;

    public Consumer(ProducerConsumerImpl sharedObject) {
        super("CONSUMER");
        this.shared = sharedObject;
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                this.shared.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
