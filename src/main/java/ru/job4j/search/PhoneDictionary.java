package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> personList = new ArrayList<>();

    public void addPerson(Person person) {
        this.personList.add(person);
    }

    public ArrayList<Person> showAllPerson(String key) {
        ArrayList<Person> personFind = new ArrayList<>();
        Predicate<Person> combineName = person -> person.getName().contains(key);
        Predicate<Person> combineSurname = person -> person.getSurname().contains(key);
        Predicate<Person> combinePhone = person -> person.getPhone().contains(key);
        Predicate<Person> combineAddress = person -> person.getAddress().contains(key);
        Predicate<Person> combine = person -> combineName.or(combineSurname)
                 .or(combinePhone).or(combineAddress).test(person);
        for (Person person : personList) {
            if (combine.test(person)) {
                personFind.add(person);
            }
        }
        return personFind;
    }
}
