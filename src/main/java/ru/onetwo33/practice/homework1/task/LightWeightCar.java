package ru.onetwo33.practice.homework1.task;

public class LightWeightCar extends Car {

    public LightWeightCar(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    @Override
    public void move() {
        if (engine.isEngineStart()) {
            System.out.println("Car is moving with 200 km/h");
        } else {
            System.out.println("You need to start engine!");
        }
    }
}
