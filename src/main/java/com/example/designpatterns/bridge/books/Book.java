package com.example.designpatterns.bridge.books;

public class Book extends Manuscript{

    protected String title;
    protected String author;
    protected String text;

    public Book(IFormatter formatter) {
        super(formatter);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void print(){
        System.out.println("Title: "+title);
        System.out.println(formatter.format("Title", title));
        System.out.println(formatter.format("Author",author));
        System.out.println(formatter.format("Text",text));
    }

}
