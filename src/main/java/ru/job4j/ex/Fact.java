package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        Fact fact = new Fact();
        fact.calc(-1);
    }

    public int calc(int i) {
        int result = 1;
        if (i < 0) {
            throw new IllegalArgumentException("Значение не может быть меньше нуля");
        }
        for (int j = 1; j <= i; j++) {
            result *= j;
        }
        return result;
    }
}
