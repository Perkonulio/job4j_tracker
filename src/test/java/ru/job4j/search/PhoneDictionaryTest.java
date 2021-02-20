package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PhoneDictionaryTest {

    @Test
    public void FindByName() {
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        Person person = new Person("Petr", "Arsentev",
                "545833", "Kaluga");
        Person person1 = new Person("Pedro", "Escobarovich", "5553535", "Columbia");
        phoneDictionary.addPerson(person);
        phoneDictionary.addPerson(person1);
        ArrayList<Person> persons = phoneDictionary.showAllPerson("3");
        assertThat(persons.get(1).getSurname(), is("Escobarovich"));
    }

}