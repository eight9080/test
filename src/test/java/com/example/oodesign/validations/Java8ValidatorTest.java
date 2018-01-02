package com.example.oodesign.validations;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Java8ValidatorTest {

    @Test
    public void validate()  {
        final Employee employee = new Employee("John", "Smith", "jogn.smith@gmail.com", 25);
        try {
            new Java8Validator().validate(employee);
        } catch (EmployeeException e) {
            Assert.fail("Employee should be valid");
        }
    }

    @Test
    public void validateNoFirstName()  {
        final Employee employee = new Employee("", "Smith", "jogn.smith@gmail.com", 25);
        try {
            new Java8Validator().validate(employee);
            Assert.fail("Employee is not valid, no firstName");
        } catch (EmployeeException e) {
            String message = e.getMessage();
            assertEquals("firstName", message);
        }
    }
}