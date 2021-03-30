package ru.job4j.streamapi;

import ru.job4j.bank.User;

public class Worker {
    private String name;
    private String surname;
    private String phone;
    private String address;
    private int insurance;

    static class Builder {
        private String name;
        private String surname;
        private String phone;
        private String address;
        private int insurance;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildPhone(String phone) {
            this.phone = phone;
            return this;
        }

        Builder buildAddress(String address) {
            this.address = address;
            return this;
        }

        Builder buildInsurance(int insurance) {
            this.insurance = insurance;
            return this;
        }

        Worker build() {
            Worker worker = new Worker();
            worker.name = name;
            worker.surname = surname;
            worker.address = address;
            worker.phone = phone;
            worker.insurance = insurance;
            return worker;
        }
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", phone='" + phone + '\''
                + ", address='" + address + '\''
                + ", insurance=" + insurance
                + '}';
    }

    public static void main(String[] args) {
        Worker worker = new Builder().buildName("name")
                .buildSurname("surname")
                .buildPhone("5553535")
                .buildAddress("Pushkina")
                .buildInsurance(55232)
                .build();
        System.out.println(worker);
    }

}
