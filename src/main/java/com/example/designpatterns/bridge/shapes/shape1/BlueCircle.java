package com.example.designpatterns.bridge.shapes.shape1;

public class BlueCircle extends Circle {
    @Override
    public void applyColor() {
        System.out.println("Applying blue color");
    }
}
