package ru.job4j.function;

import javax.swing.*;
import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biConsumer = (integer, string)
                -> map.putIfAbsent(integer, string);
        biConsumer.accept(1, "one");
        biConsumer.accept(2, "two");

        BiPredicate<Integer, String> biPredicate = (integer, string) -> {
            if (integer % 2 == 0 || string.length() == 4) {
                System.out.println("key" + integer + "value" + string);
                return true;
            }
            return false;
        };

        for (Integer i : map.keySet()) {
            biPredicate.test(i, map.get(i));
        }

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        List<String> list = sup.get();

        Consumer<String> consumer = string -> System.out.println(string);
        Function<String, String> function = string -> string.toUpperCase();
        for (String string : list) {
            consumer.accept(function.apply(string));
        }
        
    }
}
