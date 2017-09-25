package com.example.designpatterns.interpreter.breads;

public class MustardCondiment implements Condiment {
    @Override
    public void interpret(Context context) {
            context.appendOutput(" Mustard");
    }
}
