package ru.job4j.workers;

public class Surgeon extends Doctor {
    private boolean coverageScalp;
    public Surgeon(String name, String surname, String education, String birthday, boolean coverage, boolean coverageScalp) {
        super(name, surname, education, birthday, coverage);
        this.coverageScalp = coverageScalp;
    }
    public Scalp human() {
        return human();
    }
}
