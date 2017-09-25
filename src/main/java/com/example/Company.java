package com.example;

import java.util.HashSet;
import java.util.Set;

public class Company {
    private String companyName;
    private Set<String> products;

    public Company(String companyName) {
        this.setCompanyName(companyName);
        this.products = new HashSet<>();
    }

    public void add(String product) {
        this.products.add(product);
    }

    public Set<String> getProducts() {
        return products;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
