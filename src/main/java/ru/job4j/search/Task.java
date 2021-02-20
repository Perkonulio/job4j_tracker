package ru.job4j.search;

public class Task {
    private String descrip;
    private int priority;

    public Task(String descrip, int priority) {
        this.descrip = descrip;
        this.priority = priority;
    }

    public String getDescrip() {
        return descrip;
    }

    public int getPriority() {
        return priority;
    }
}
