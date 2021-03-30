package ru.job4j.streamapi;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public List<Adress> collect(List<Profile> list) {
        return list.stream().
                map(Profile::getAdress)
                .sorted(Comparator.comparing(Adress::getCity))
                .distinct()
                .collect(Collectors.toList());
    }
}
