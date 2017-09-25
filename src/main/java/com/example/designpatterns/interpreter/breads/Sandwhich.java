package com.example.designpatterns.interpreter.breads;

// <sandwhich> ::= <bread> <condimentList> <ingredientList> <condimentList> <bread>
public class Sandwhich implements Expression {

    private final Bread topBread;
    private final CondimentList topCondiments;
    private final IngredientList ingredientList;
    private final CondimentList bottomCondiments;
    private final Bread bottomBread;

    public Sandwhich(Bread topBread, CondimentList topCondiments,
                     IngredientList ingredientList, CondimentList bottomCondiments, Bread bottomBread) {
        this.topBread = topBread;
        this.topCondiments = topCondiments;
        this.ingredientList = ingredientList;
        this.bottomCondiments = bottomCondiments;
        this.bottomBread = bottomBread;
    }

    @Override
    public void interpret(Context context) {
        context.appendOutput("|");
        topBread.interpret(context);
        context.appendOutput("|");
        context.appendOutput("<--");
        topCondiments.interpret(context);
        context.appendOutput("-");
        ingredientList.interpret(context);
        context.appendOutput("-");
        bottomCondiments.interpret(context);
        context.appendOutput("-->");
        context.appendOutput("|");
        bottomBread.interpret(context);
        context.appendOutput("|");
        System.out.println(context.getFinalOutput());
    }
}
