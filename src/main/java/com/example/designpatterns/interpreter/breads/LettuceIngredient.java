package com.example.designpatterns.interpreter.breads;

public class LettuceIngredient implements Ingredient {
    @Override
    public void interpret(Context context) {
            context.appendOutput(" Letuce");
    }
}
