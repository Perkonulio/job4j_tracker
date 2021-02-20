package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConvertList {
    public List<Integer> convert(List<int[]> array) {
        List<Integer> list = new ArrayList<>();
        for(int[] value : array) {
            for(int number : value) {
                list.add(number);
            }
        }
        return list;
    }


}
