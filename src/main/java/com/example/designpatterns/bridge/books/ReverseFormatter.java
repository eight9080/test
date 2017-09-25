package com.example.designpatterns.bridge.books;

public class ReverseFormatter implements IFormatter {
    @Override
    public String format(String key, String value) {
        return key+": "+new StringBuilder(value).reverse();
    }
}
