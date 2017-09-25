package com.example.designpatterns.mediator.light;

public class MediatorDemo {

    public static void main(String[] args) {
        final Mediator mediator = new Mediator();

        final Light bedroomLight = new Light("Bedroom");
        final Light kitchenLight = new Light("Kitchen");

        mediator.registerLight(bedroomLight);
        mediator.registerLight(kitchenLight);

        final TurnOnAllLightsCommand turnOnAllLightsCommand = new TurnOnAllLightsCommand(mediator);
        turnOnAllLightsCommand.execute();

        final TurnOffAllLightsCommand turnOffAllLightsCommand = new TurnOffAllLightsCommand(mediator);
        turnOffAllLightsCommand.execute();

    }
}