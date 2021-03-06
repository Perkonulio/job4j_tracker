package ru.job4j.streamapi;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProfilesTest {
    @Test
    public void whenAccessTestProfiles() {
        List<Profile> profileList = List.of(
                new Profile(new Adress("New York", "Pushkina", 21, 125)),
                new Profile(new Adress("Belogorsk", "Plimvutova", 25, 324)),
                new Profile(new Adress("New York", "Markova", 22, 1)),
                new Profile(new Adress("New York", "Markova", 22, 1)));
        List<Adress> expected = List.of(
                new Adress("Belogorsk", "Plimvutova", 25, 324),
                new Adress("New York", "Pushkina", 21, 125),
                new Adress("New York", "Markova", 22, 1));
        Profiles profiles = new Profiles();
        List<Adress> list = profiles.collect(profileList);
        assertThat(list, is(expected));
    }

}