package com.example.designpatterns.bridge.shapes.shape1;

public class RedSquare extends Square {
    @Override
    public void applyColor() {
        System.out.println("Applying red color");
    }
}