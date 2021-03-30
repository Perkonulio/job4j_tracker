package ru.job4j.streamapi;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DoubleLoop {
    public static void main(String[] args) {
        List<Card> list1 = Stream.of(Suit.values())
                .flatMap(value -> Stream.of(Value.values())
                        .map(element -> new Card(value, element)))
                .collect(Collectors.toList());
        for (Card card : list1) {
            System.out.println(card);
        }
    }
}
