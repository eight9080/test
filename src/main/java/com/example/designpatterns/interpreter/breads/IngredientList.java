package com.example.designpatterns.interpreter.breads;

import java.util.List;
// <ingredientList> ::= { <ingredient> }
public class IngredientList implements Expression{

    private final List<Ingredient> ingredients;

    public IngredientList(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public void interpret(Context context) {
        ingredients.forEach(ingredient -> ingredient.interpret(context));
    }
}
