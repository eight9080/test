package com.example.designpatterns.iterator.bike;

import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {

        BikeRepository repo = new BikeRepository();
        repo.addBike("Cervelo");
        repo.addBike("Scott");
        repo.addBike("Fugi");

        Iterator<String> bikeIterator = repo.iterator();

        while (bikeIterator.hasNext()){
            System.out.println(bikeIterator.next());
        }

        for (String bike: repo) {
            System.out.println(bike);
        }
    }
}