package com.example.designpatterns.interpreter.breads;

import java.util.List;

// <condimentList> ::= { <condiment> }
public class CondimentList implements Expression{

    private final List<Condiment> condiments;

    public CondimentList(List<Condiment> condiments) {
        this.condiments = condiments;
    }

    @Override
    public void interpret(Context context) {
        condiments.forEach(condiment -> condiment.interpret(context));
    }
}
