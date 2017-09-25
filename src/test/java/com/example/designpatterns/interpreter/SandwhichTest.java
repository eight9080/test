package com.example.designpatterns.interpreter;

import com.example.designpatterns.interpreter.breads.*;
import org.junit.Test;

import java.util.Arrays;

public class SandwhichTest {
    @Test
    public void interpret() throws Exception {

        final Sandwhich sandwhich = new Sandwhich(
                new WheatBread(), new CondimentList(Arrays.asList(new MustardCondiment(), new MayoCondiment())),
                new IngredientList(Arrays.asList(new ChickenIngredient(), new LettuceIngredient())),
                new CondimentList(Arrays.asList(new KetchupCondiment())),
                new WheatBread());
        sandwhich.interpret(new Context());


    }

}