package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int size) {
        load = size;
    }
    public void exchange(Battery another) {
        another.load = this.load + another.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery bat1 = new Battery(100);
        Battery bat2 = new Battery(120);
        bat1.exchange(bat2);
    }
}
