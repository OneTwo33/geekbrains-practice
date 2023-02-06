package ru.onetwo33.practice.homework1.task;

public abstract class Car implements Moveable, Stopable {

    public Engine engine = new Engine();
    private String color;
    private String name;

    public void open() {
        System.out.println("Car is open");
    }

    @Override
    public void stop(){
        System.out.println("Car is stop");
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
