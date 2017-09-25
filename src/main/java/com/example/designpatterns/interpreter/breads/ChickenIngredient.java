package com.example.designpatterns.interpreter.breads;

public class ChickenIngredient implements Ingredient {
    @Override
    public void interpret(Context context) {
            context.appendOutput(" Chicken");
    }
}
