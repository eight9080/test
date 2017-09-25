package com.example.designpatterns.interpreter.breads;

public class WhiteBread implements Bread {
    @Override
    public void interpret(Context context) {
        context.appendOutput(" White-Bread");
    }
}
