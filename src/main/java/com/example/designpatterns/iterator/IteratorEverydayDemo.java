package com.example.designpatterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorEverydayDemo {
    public static void main(String[] args) {
        final List<String> names = new ArrayList<>();
        names.add("Bryan");
        names.add("Aaron");
        names.add("Jason");

        final Iterator<String> iterator = names.iterator();

        while (iterator.hasNext()){
            final String name = iterator.next();
            System.out.println(name);
            iterator.remove();
        }
        System.out.println("Size collection: "+names.size());

    }
}
