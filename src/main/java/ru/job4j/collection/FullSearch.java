package ru.job4j.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class FullSearch {
    public static HashSet<String> extractNumber(List<Task> task) {
        HashSet<String> numbers = new HashSet<>();
        for (Task list : task) {
            numbers.add(list.getNumber());
        }
        return numbers;

    }

}
