package ru.job4j.workers;

public class Engineer extends Profession{
    int money;
    public Engineer(String name, String surname, String education, String birthday, int money) {
        super(name, surname, education, birthday);
        this.money = money;
    }
    public Construct plain() {
        return plain();
    }
}
