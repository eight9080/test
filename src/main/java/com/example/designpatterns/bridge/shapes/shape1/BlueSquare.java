package com.example.designpatterns.bridge.shapes.shape1;

public class BlueSquare extends Square {
    @Override
    public void applyColor() {
        System.out.println("Applying blue color");
    }
}