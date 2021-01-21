package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Врумврумврум");
    }

    @Override
    public void speed() {
        System.out.println("60 km/h");
    }

    public void transport() {
        System.out.println("4 колеса");
    }
}
