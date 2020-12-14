package ru.job4j.oop;

public class Cat {
    private String name;
    private String food;

    public void show() {
        System.out.println(name + " " + food);
    }

    public void eat(String meat) {
        food = meat;
    }

    public void giveNick(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Cat black = new Cat();
        black.eat("Chicken");
        black.giveNick("Zhorzh");
        black.show();
    }

}
