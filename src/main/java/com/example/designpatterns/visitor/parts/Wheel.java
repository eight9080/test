package com.example.designpatterns.visitor.parts;

public class Wheel implements AtvPart {

    @Override
    public void accept(AtvPartVisitor visitor) {
        visitor.visit(this);
    }
}
