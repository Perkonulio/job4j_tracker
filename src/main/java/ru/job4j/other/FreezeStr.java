package ru.job4j.other;

import javax.swing.*;
import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char[] leftChar = left.toCharArray();
        char[] rightChar = right.toCharArray();
        for (char character : leftChar) {
            int counter = 1;
            if (map1.containsKey(character)) {
                counter = map1.get(character);
                counter++;
            }
            map1.put(character, counter);
        }

        for (char character : rightChar) {
            int counter = 1;
            if (map2.containsKey(character)) {
                counter = map2.get(character);
                counter++;
            }
            map2.put(character, counter);
        }

        for (char character : map1.keySet()) {
            if (!map2.containsKey(character) || !map1.get(character).equals(map2.get(character))) {
                return false;
            }
        }

        return true;
    }
}
