package ru.job4j.strategy;

public class Triangle implements Shape {
    @Override
    public String draw() {
        String line = System.lineSeparator();
        return    "   ^    " + line
                + " /   \\ " + line
                + "/_____\\" + line;
    }
}
