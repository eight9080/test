package com.example.designpatterns.interpreter.breads;

public class KetchupCondiment implements Condiment {
    @Override
    public void interpret(Context context) {
            context.appendOutput(" Ketchup");
    }
}
