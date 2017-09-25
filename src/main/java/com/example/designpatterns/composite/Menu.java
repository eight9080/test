package com.example.designpatterns.composite;

public class Menu extends MenuComponent {

    public Menu(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public MenuComponent add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
        return menuComponent;
    }

    public MenuComponent remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
        return menuComponent;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();

        builder.append(print(this));

        menuComponents.forEach(menuComponent -> builder.append(menuComponent.toString()));

        return builder.toString();
    }
}
