package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class RefMethod {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ivan", "Petr Arsentev");
        Consumer<String> out = RefMethod::cutOut;
        names.forEach(out);
    }

    public static void cutOut(String name) {
        if (name.length() > 10) {
            System.out.println(name.substring(0, 10) + "...");
        } else {
            System.out.println(name);
        }
    }
}
