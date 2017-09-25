package com.example.designpatterns.bridge.books;

public class TermPaper extends Manuscript{

    private String classHour;
    private String student;
    private String text;
    private String references;

    public TermPaper(IFormatter formatter) {
        super(formatter);
    }


    public void setClassHour(String classHour) {
        this.classHour = classHour;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public void print(){
        System.out.println(formatter.format("Class",classHour));
        System.out.println(formatter.format("Student",student));
        System.out.println(formatter.format("Text",text));
        System.out.println(formatter.format("References",references));
    }

}
