package com.example.designpatterns.interpreter.breads;

public class MayoCondiment implements Condiment {
    @Override
    public void interpret(Context context) {
            context.appendOutput(" Mayo");
    }
}
