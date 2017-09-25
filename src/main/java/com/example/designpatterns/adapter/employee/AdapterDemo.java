package com.example.designpatterns.adapter.employee;

import java.util.List;

public class AdapterDemo {

    public static void main(String[] args) {
        EmployeeClient client = new EmployeeClient();
        List<Employee> employees = client.getEmployeesList();

        System.out.println(employees);
    }
}
