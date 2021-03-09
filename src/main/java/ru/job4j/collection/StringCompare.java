package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int length = 0;
        int otherLength;
        if(left.equals(right))  {
            return result;
        } else {
           if (left.length() < right.length() ? length = right.length() : length = left.length()) {
               if(length == right.length()) {
                   otherLength = left.length();
               } else {
                   otherLength = right.length();
               }
               for (int i = 0; i < length; i++) {
                   if(i > otherLength - 1) {
                       result += Integer.compare(left.length(), right.length());
                       break;
                   } else {
                       result += Character.compare(left.charAt(i), right.charAt(i));
                   }
               }
           }
        }
        return result;
    }
}
