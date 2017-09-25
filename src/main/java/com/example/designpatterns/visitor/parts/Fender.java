package com.example.designpatterns.visitor.parts;

public class Fender implements AtvPart {

    @Override
    public void accept(AtvPartVisitor visitor) {
        visitor.visit(this);
    }
}
