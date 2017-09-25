package com.example.designpatterns.memento;

public class MementoDemo {

    public static void main(String[] args) {
        final Caretaker caretaker = new Caretaker();

        final Employee employee = new Employee();
        employee.setName("John");
        employee.setAddress("111 Main street");
        employee.setPhone("888-23-23-23-11");

        System.out.println("Employee before save: " +employee);

        caretaker.save(employee);

        employee.setPhone("01112222344");

        caretaker.save(employee);
        System.out.println("Employee after changed phone number save: " +employee);

        employee.setPhone("03434343434");

        caretaker.revert(employee);

        System.out.println("Reverts to last save point: " +employee);

        caretaker.revert(employee);

        System.out.println("Reverts to original: " +employee);
    }
}
