package com.example.designpatterns.bridge.books;

public class StandardFormatter implements IFormatter {
    @Override
    public String format(String key, String value) {
        return key+": "+value;
    }
}
