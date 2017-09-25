package com.example.designpatterns.bridge.shapes.shape2;

public class Circle extends Shape {
    public Circle(Color red) {
        super(red);
    }

    @Override
    void applyColor() {
        color.applyColor();
    }
}
