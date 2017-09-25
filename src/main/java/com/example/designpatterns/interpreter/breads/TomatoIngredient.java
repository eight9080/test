package com.example.designpatterns.interpreter.breads;

public class TomatoIngredient implements Ingredient {
    @Override
    public void interpret(Context context) {
            context.appendOutput(" Tomato");
    }
}
