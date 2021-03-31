package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.addPerson(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.showAllPerson("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

}