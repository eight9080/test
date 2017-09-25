package com.example.designpatterns.factory.factory1;

import com.example.designpatterns.factory.factory1.cars.BMW335Xi;
import com.example.designpatterns.factory.factory1.cars.MiniCooper;
import com.example.designpatterns.factory.factory1.cars.NullCar;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AutoFactoryTest {
    @Test
    public void getCar() throws Exception {
        final AutoFactory autoFactory = new AutoFactory();
        final IAuto bmw = autoFactory.createInstance("bmw");
        assertThat(bmw instanceof BMW335Xi, is(true));
        final IAuto mini = autoFactory.createInstance("mini");
        assertThat(mini instanceof MiniCooper, is(true));
        final IAuto nullCar = autoFactory.createInstance("asda");
        assertThat(nullCar instanceof NullCar, is(true));

        bmw.turnOn();
        bmw.turnOff();
        mini.turnOn();
        mini.turnOff();
    }

}