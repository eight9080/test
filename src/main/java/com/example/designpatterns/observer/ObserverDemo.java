package com.example.designpatterns.observer;

public class ObserverDemo {

    public static void main(String[] args) {
        Subject subject = new MessageStream();

        PhoneClient phoneClient = new PhoneClient(subject);
        TabletClient tabletClient = new TabletClient(subject);

        phoneClient.addMessage("message phone");
        tabletClient.addMessage("message tablet");

    }

}