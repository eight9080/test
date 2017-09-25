package com.example.designpatterns.factory.factory2;

import com.example.designpatterns.factory.factory1.IAuto;
import com.example.designpatterns.factory.factory1.cars.BMW335Xi;
import com.example.designpatterns.factory.factory1.cars.MiniCooper;
import com.example.designpatterns.factory.factory1.cars.NullCar;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AutoFactoryTest {
    @Test
    public void createAutomobile() throws Exception {
        final IAutoFactory bmwFactory = new BmwFactory();
        final IAuto bmw = bmwFactory.createAutomobile();
        assertThat(bmw instanceof BMW335Xi, is(true));
        final IAutoFactory miniFactory = new MiniCooperFactory();
        final IAuto mini = miniFactory.createAutomobile();
        assertThat(mini instanceof MiniCooper, is(true));
//        final IAutoFactory miniFactory = new MiniCooperFactory();
//        final IAuto nullCar = bmwFactory.createAutomobile();
//        assertThat(nullCar instanceof NullCar, is(true));

        bmw.turnOn();
        bmw.turnOff();
        mini.turnOn();
        mini.turnOff();
    }

}