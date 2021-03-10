package ru.job4j.collection;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        PassportOffice pass = new PassportOffice();
        Citizen citizen = new Citizen("9504", "Petr");
        pass.add(citizen);
        assertThat(pass.getCitizens(citizen.getPassport()), is(citizen));
    }
}