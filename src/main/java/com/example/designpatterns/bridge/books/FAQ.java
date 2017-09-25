package com.example.designpatterns.bridge.books;

import java.util.HashMap;
import java.util.Map;

public class FAQ extends Manuscript{

    private String title;
    private Map<String, String> questions = new HashMap<>();

    public FAQ(IFormatter formatter) {
        super(formatter);
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void addQuestion(String question, String answer){
        questions.put(question, answer);
    }

    public void print(){
        System.out.println(formatter.format("Title",title));
        questions.forEach((question , answer) -> {
            System.out.println(formatter.format("Question",question));
            System.out.println(formatter.format("Answer",answer));
        });
    }

}
