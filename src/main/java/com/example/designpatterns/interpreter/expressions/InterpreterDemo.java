package com.example.designpatterns.interpreter.expressions;

public class InterpreterDemo {

    static Expression buildInterpreterTree(){
        Expression terminal1 = new TerminalExpression("Lions");
        Expression terminal2 = new TerminalExpression("Tigers");
        Expression terminal3 = new TerminalExpression("Bears");

        //Tigers and Bears
        final AndExpression alternative1 = new AndExpression(terminal2, terminal3);

        //Lions or (Tigers and Bears)
        final OrExpression alternative2 = new OrExpression(terminal1, alternative1);

        return new AndExpression(terminal3, alternative2);
    }

    public static void main(String[] args) {
//        String context = "Lions";
//        String context = "Tigers";
//        String context = "Lions Tigers";
        String context = "Bears Tigers";

        final Expression define = buildInterpreterTree();
        System.out.println(context+" is "+define.interpret(context));
    }
}