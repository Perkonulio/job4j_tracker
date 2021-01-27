package ru.job4j.strategy;

public class Square implements Shape {
    @Override
    public String draw() {
        String line = System.lineSeparator();
        return     "----" + line
                + "|    |" + line
                +  "----" + line;
    }
}
