package com.example.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuComponent {
    protected String name;
    protected String url;
    protected List<MenuComponent> menuComponents = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public  abstract String toString();

    protected String print(MenuComponent menuComponent){
        return  name+": "+url+"\n";
    }
}