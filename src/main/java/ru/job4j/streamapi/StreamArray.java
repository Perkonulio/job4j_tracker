package ru.job4j.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamArray {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, -2, 3, 4);
        List<Integer> listOut = list.stream().filter(elementList -> elementList >= 0)
                .collect(Collectors.toList());
        listOut.forEach(System.out::println);
    }
}
