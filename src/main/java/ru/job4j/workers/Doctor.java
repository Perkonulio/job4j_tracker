package ru.job4j.workers;

public class Doctor extends Profession {
    private boolean coverage;

    public Doctor(String name, String surname, String education,
                  String birthday, boolean coverage) {
        super(name, surname, education, birthday);
        this.coverage = coverage;
    }

    public Diagnosis heal() {
        return heal();
    }
}
