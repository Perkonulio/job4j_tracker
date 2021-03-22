package ru.job4j.collection_final;

import java.util.Comparator;

public class DepDesComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String o1Result = o1.split("/")[0];
        String o2Result = o2.split("/")[0];
        int result;
        result = o2Result.compareTo(o1Result);
        if (result == 0) {
            return o1.compareTo(o2);
        }
        return result;
    }
}
