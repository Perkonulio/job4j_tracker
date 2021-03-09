package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int length;
        if(left.equals(right))  {
            return result;
        } else {
           length = Math.min(left.length(), right.length());
            for (int i = 0; i < length ; i++) {
                result = Character.compare(left.charAt(i), right.charAt(i));
                if(result == 0) {
                    result = Integer.compare(left.length(), right.length());
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
