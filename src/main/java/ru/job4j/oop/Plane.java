package ru.job4j.oop;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println("ВЖЖЖЖЖЖ");
    }

    @Override
    public void speed() {
        System.out.println("900 km/h");
    }
}
