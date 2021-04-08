package ru.job4j.other;

import java.util.Arrays;
import java.util.HashSet;

public class Article {
    public static boolean generateBy(String origin, String line) {
        HashSet<String> line1 = new HashSet<>();
        HashSet<String> line2 = new HashSet<>();
        line1.addAll(Arrays.asList(origin.split("\\s*(\\s|,|!|\\.)\\s*")));
        line2.addAll(Arrays.asList(line.split("\\s*(\\s|,|!|\\.)\\s*")));
        return line1.containsAll(line2);
    }
}
