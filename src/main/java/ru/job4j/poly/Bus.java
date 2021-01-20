package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Bus gone");
    }

    @Override
    public void passanger(int pass) {
        System.out.println("Bus take passanger");
    }

    @Override
    public int pitStop(int fuel) {
        return fuel * 45;
    }
}
