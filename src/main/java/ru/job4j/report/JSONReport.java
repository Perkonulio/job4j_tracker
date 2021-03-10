package ru.job4j.report;

public class JSONReport extends TextReport {
    @Override
    public String text(String name, String body) {
        return name + ":" + "name" + System.lineSeparator() + body + ":" + "body";
    }
}
