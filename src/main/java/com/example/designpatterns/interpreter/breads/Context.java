package com.example.designpatterns.interpreter.breads;

public class Context {
    private StringBuilder output = new StringBuilder();

    public String getFinalOutput() {
        return output.toString();
    }

    public void appendOutput(String output) {
        this.output.append(output);
    }
}
