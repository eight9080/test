package com.example.designpatterns.decorator;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PizzaTest {

    @Test
    public void calculateCost() throws Exception {
        Pizza largePizza = new LargePizza();


        assertThat(largePizza.getDescription(), is("Large Pizza"));
        assertThat(largePizza.calculateCost(), is(9.00));

        largePizza = new Cheese(largePizza);
        assertThat(largePizza.getDescription(), is("Large Pizza, Cheese"));
        assertThat(largePizza.calculateCost(), is(10.25));

        largePizza = new Ham(largePizza);
        assertThat(largePizza.getDescription(), is("Large Pizza, Cheese, Ham"));
        assertThat(largePizza.calculateCost(), is(11.25));

        largePizza = new Peppers(largePizza);
        assertThat(largePizza.getDescription(), is("Large Pizza, Cheese, Ham, Peppers"));
        assertThat(largePizza.calculateCost(), is(13.25));

    }
}