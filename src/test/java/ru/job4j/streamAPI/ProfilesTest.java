package ru.job4j.streamAPI;

import com.sun.nio.sctp.PeerAddressChangeNotification;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProfilesTest {
    @Test
    public void whenAccessTestProfiles() {
        List<Profile> profileList = List.of(
                new Profile(new Adress("New York", "Pushkina", 21, 125)),
                new Profile(new Adress("Belogorsk", "Plimvutova", 25, 324)));
        List<Adress> expected = List.of(
                new Adress("New York", "Pushkina", 21, 125),
                new Adress("Belogorsk", "Plimvutova", 25, 324));
        Profiles profiles = new Profiles();
        List<Adress> list = profiles.collect(profileList);
        assertThat(list, is(expected));
    }

}