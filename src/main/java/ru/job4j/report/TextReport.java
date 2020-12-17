package ru.job4j.report;

public class TextReport {
    public String text(String name, String body) {
        return name + System.lineSeparator() + body;
    }
}
