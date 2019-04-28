package com.example.general;

public class MethodsO {

    public static void main(String[] args) {
        Parent p = new Parent();
        Parent c = new Child();
        p.watch();
        c.watch();
    }
}

class Parent {
    public void watch() {
        System.out.println("Parent watching movies");
    }
}

class Child extends Parent {
    @Override
    public void watch() {
        System.out.println("Child watching Cartoons ");
    }
}

