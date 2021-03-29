package ru.job4j.streamAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Profiles {

    public List<Adress> collect(List<Profile> list) {
        return list.stream().sorted(new CompareAddress())
                .distinct()
                .map(Profile::getAdress)
                .collect(Collectors.toList());
    }
}
