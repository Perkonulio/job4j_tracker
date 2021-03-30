package ru.job4j.streamapi;

import java.util.Objects;

public class Profile {
    private Adress adress;

    public Profile(Adress adress) {
        this.adress = adress;
    }

    public Adress getAdress() {
        return adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profile profile = (Profile) o;
        return Objects.equals(adress, profile.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adress);
    }
}
