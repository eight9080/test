package com.example.designpatterns.interpreter.breads;

public class WheatBread implements Bread {
    @Override
    public void interpret(Context context) {
        context.appendOutput(" Wheat-Bread");
    }
}
