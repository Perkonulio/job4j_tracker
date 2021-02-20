package ru.job4j.collection;

import java.util.Objects;

public class Account {
    private String pasport;
    private String name;
    private String deposit;


    public Account(String pasport, String name, String deposit) {
        this.pasport = pasport;
        this.name = name;
        this.deposit = deposit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(pasport, account.pasport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pasport, name, deposit);
    }

    @Override
    public String toString() {
        return "Account{" +
                "pasport='" + pasport + '\'' +
                ", name='" + name + '\'' +
                ", deposit='" + deposit + '\'' +
                '}';
    }
}
