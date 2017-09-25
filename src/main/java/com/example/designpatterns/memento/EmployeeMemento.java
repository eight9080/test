package com.example.designpatterns.memento;
//memento
public class EmployeeMemento {

    private String name;
    private String phone;

    public EmployeeMemento(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "EmployeeMemento{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
