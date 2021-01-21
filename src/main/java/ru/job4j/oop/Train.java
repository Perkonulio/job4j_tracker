package ru.job4j.oop;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Чу-чу-чу-чух Чу-чу-чу-чух");
    }

    @Override
    public void speed() {
        System.out.println("200 km/h");
    }
}
