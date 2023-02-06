package ru.onetwo33.practice.homework1;

import ru.onetwo33.practice.homework1.person.Person;
import ru.onetwo33.practice.homework1.person.PersonBuilder;
import ru.onetwo33.practice.homework1.shapes.Circle;
import ru.onetwo33.practice.homework1.shapes.Shape;
import ru.onetwo33.practice.homework1.shapes.Square;
import ru.onetwo33.practice.homework1.task.Car;
import ru.onetwo33.practice.homework1.task.LightWeightCar;
import ru.onetwo33.practice.homework1.task.Lorry;

public class Main {

    public static void main(String[] args) {
        // 1. Создать builder для класса Person
        Person person = new PersonBuilder()
                .withFirstName("Alex")
                .withAddress("Moscow")
                .withAge(30)
                .withGender("Male")
                .withPhone("+79999999999")
                .build();

        System.out.println(person);

        // 2. Описать ошибки в коде (см. задание в методичке) и предложить варианты оптимизации.
        // - нужно создать класс Engine
        // - перенести реализацию Stopable и Moveable в класс Car, все машины должны уметь двигаться и останавливаться
        // - перенести логику start(), в класс Engine
        // - реализовать метод open() в абстрактном классе Car и сделать public, все машины должны уметь открываться
        System.out.println("------");
        Car lightWeightCar = new LightWeightCar();
        lightWeightCar.open();
        lightWeightCar.engine.start();
        lightWeightCar.move();

        Car lorry = new Lorry();
        lightWeightCar.open();
        lorry.engine.start();
        lorry.move();

        // 3. Написать пример кода, который реализует принцип полиморфизма, на примере фигур — круг, квадрат, треугольник
        System.out.println("------");
        Shape shape = new Circle();
        shape.sayType();
        shape = new Square();
        shape.sayType();
    }
}
