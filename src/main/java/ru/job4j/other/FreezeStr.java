package ru.job4j.other;

import javax.swing.*;
import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> map1 = new HashMap<>();
        char[] leftChar = left.toCharArray();
        for (char character : leftChar) {
            int counter = 1;
            if (map1.containsKey(character)) {
                counter = map1.get(character);
                counter++;
            }
            map1.put(character, counter);
        }
        char[] rightChar = right.toCharArray();
        for (Character character : rightChar) {
            if (!map1.containsKey(character)) {
                return false;
            } else if (map1.containsKey(character) && map1.get(character) == 1) {
                map1.remove(character);
            } else if (map1.containsKey(character) && map1.get(character) > 1) {
                map1.put(character, map1.get(character) - 1);
            }
        }
        return map1.isEmpty();
    }
}
