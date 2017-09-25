package com.example.designpatterns.rules;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DiscountCalculatorTest {
        private DiscountCalculator discountCalculator = new DiscountCalculator();


        @Test
        public void return15PctForNewCustomer(){
            Customer customer = new Customer(null, LocalDate.now().plusYears(-20).plusMonths(-2), false);

            double discount = discountCalculator.calculateDiscountPercentage(customer);

            assertThat(discount, is(0.15D));
        }

        @Test
        public void Return10PctForVeteran(){
            Customer customer = new Customer(LocalDate.now().plusDays(-1), LocalDate.now().plusYears(-30).plusMonths(3), true);

            double discount = discountCalculator.calculateDiscountPercentage(customer);

            assertThat(discount, is(0.1D));
        }

        @Test
        public void return5PctForSenior(){
            Customer customer = new Customer(LocalDate.now().plusDays(-1),
                    LocalDate.now().plusYears(-65).plusDays(-5), false);

            double discount = discountCalculator.calculateDiscountPercentage(customer);
            assertThat(discount, is(0.05D));
        }

        @Test
        public void return10PctForBirthday(){

            Customer customer = new Customer(LocalDate.now().plusDays(-1),
                    LocalDate.now(), false);
            double discount = discountCalculator.calculateDiscountPercentage(customer);
            assertThat(discount, is(0.10D));
        }

        @Test
        public void return12PctFor5YearLoyalCustomer(){
            Customer customer = new Customer(LocalDate.now().plusYears(-5),
                    LocalDate.now().plusDays(-5), false);
            double discount = discountCalculator.calculateDiscountPercentage(customer);
            assertThat(discount, is(0.12D));
        }

        @Test
        public void return22PctFor5YearLoyalCustomerOnBirthday(){
            Customer customer = new Customer(LocalDate.now().plusYears(-5).plusDays(-1),
                    LocalDate.now(), false);
            double discount = discountCalculator.calculateDiscountPercentage(customer);
            assertThat(discount, is(0.22D));
        }




}