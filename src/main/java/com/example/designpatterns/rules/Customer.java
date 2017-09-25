package com.example.designpatterns.rules;

import java.time.LocalDate;

public class Customer {

    public LocalDate dateOfFirstPurchase;
    public LocalDate dateOfBirth;
    public boolean veteran;

    public Customer() {
    }

    public Customer(LocalDate dateOfFirstPurchase, LocalDate dateOfBirth, boolean veteran) {
        this.dateOfFirstPurchase = dateOfFirstPurchase;
        this.dateOfBirth = dateOfBirth;
        this.veteran = veteran;
    }

    public LocalDate getDateOfFirstPurchase() {
        return dateOfFirstPurchase;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isVeteran() {
        return veteran;
    }
}
