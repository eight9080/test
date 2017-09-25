package com.example.designpatterns.factory.factory2;

import com.example.designpatterns.factory.factory1.IAuto;
import com.example.designpatterns.factory.factory1.cars.BMW335Xi;

public class BmwFactory implements IAutoFactory {
    @Override
    public IAuto createAutomobile() {
        final BMW335Xi bmw = new BMW335Xi();
        bmw.setName("BMW M5 Cabriolet");
        return bmw;
    }
}
