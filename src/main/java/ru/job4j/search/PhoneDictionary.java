package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> personList = new ArrayList<>();

    public void addPerson(Person person) {
        this.personList.add(person);
    }

    public ArrayList<Person> showAllPerson(String key) {
        ArrayList<Person> personFind = new ArrayList<>();
        for (Person person: personList) {
            if(person.getName().contains(key) || person.getSurname().contains(key) ||
                    person.getAddress().contains(key) || person.getPhone().contains(key)) {
                personFind.add(person);
            }
        }
        return personFind;
    }
}
