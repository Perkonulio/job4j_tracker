package ru.job4j.workers;

public class Dantist extends Doctor{
    boolean coverageTeeth;

    public Dantist(String name, String surname, String education, String birthday, boolean coverage, boolean coverageTeeth) {
        super(name, surname, education, birthday, coverage);
        this.coverageTeeth = coverageTeeth;
    }

    public DrillTeeth drill() {
        return drill();
    }
}
