package com.example.designpatterns.factory.factory2;

import com.example.designpatterns.factory.factory1.IAuto;
import com.example.designpatterns.factory.factory1.cars.MiniCooper;

public class MiniCooperFactory implements IAutoFactory {
    @Override
    public IAuto createAutomobile() {
        final MiniCooper miniCooper = new MiniCooper();
        miniCooper.setName("Mini Cooper S");
        return miniCooper;
    }
}
