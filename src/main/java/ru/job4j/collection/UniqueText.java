package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String origin, String text) {
        boolean result = true;
        String[] originText = origin.split(" ");
        String[] duplicateText = text.split(" ");
        HashSet<String> equality = new HashSet<>();
        for (String words : originText) {
            equality.add(words);
        }
        for (String duplicate : duplicateText) {
            if(!equality.contains(duplicate)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
