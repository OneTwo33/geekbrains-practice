package ru.onetwo33.practice.homework1.task;

public class CarEngine implements Engine {

    private boolean engineStart = false;

    public void start() {
        this.engineStart = true;
        System.out.println("Engine is started");
    }

    public void stop() {
        this.engineStart = false;
        System.out.println("Engine is stopped");
    }

    public boolean isEngineStart() {
        return this.engineStart;
    }
}
