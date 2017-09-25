package com.example.designpatterns.bridge;

import com.example.designpatterns.bridge.books.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BridgeTest {

    @Test
    public void papersItems() throws Exception {

        List<Manuscript> documents = new ArrayList<>();

//        final StandardFormatter formatter = new StandardFormatter();
        final IFormatter formatter = new ReverseFormatter();

        final FAQ faq = new FAQ(formatter);
        faq.setTitle("The Bridge Pattern FAQ");
        faq.addQuestion("What is it?", "A design pattern");
        faq.addQuestion("When do we use it?", "When you need to separate an abstraction from an implementation.");
        documents.add(faq);


        final Book book = new Book(formatter);
        book.setTitle("Lots of Patterns");
        book.setAuthor("John Sonmez");
        book.setText("Blah blah blah...");
        documents.add(book);

        final TermPaper paper = new TermPaper(formatter);
        paper.setClassHour("Design Patterns");
        paper.setStudent("Joe N00b");
        paper.setText("Blah blah blah...");
        paper.setReferences("GOF");
        documents.add(paper);

        documents.stream().forEach(doc -> doc.print());

    }
}
