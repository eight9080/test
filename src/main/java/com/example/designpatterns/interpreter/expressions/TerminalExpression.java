package com.example.designpatterns.interpreter.expressions;

import java.util.StringTokenizer;

public class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        final StringTokenizer st = new StringTokenizer(context);
        while (st.hasMoreTokens()){
            final String test = st.nextToken();
            if(test.equals(data)){
                return true;
            }
        }
        return false;
    }
}
