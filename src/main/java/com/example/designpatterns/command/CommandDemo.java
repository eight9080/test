package com.example.designpatterns.command;

import java.util.Arrays;
import java.util.List;

public class CommandDemo {
    public static void main(String[] args) {
        Light bedroomLight = new Light();
        Light kitchenLight = new Light();
        Switch lightSwitch = new Switch();

//        Command onCommand = new OnCommand(bedroomlight);
//        lightSwitch.storeAndExecute(onCommand);

        final Command toggleCommand = new ToggleCommand(bedroomLight);
        lightSwitch.storeAndExecute(toggleCommand);
//        lightSwitch.storeAndExecute(toggleCommand);
//        lightSwitch.storeAndExecute(toggleCommand);

        final List<Light> lights = Arrays.asList(bedroomLight, kitchenLight);
        Command allLightCommand = new AllLightCommand(lights);
        lightSwitch.storeAndExecute(allLightCommand);
        lightSwitch.storeAndExecute(allLightCommand);

    }
}