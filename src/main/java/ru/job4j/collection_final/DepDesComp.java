package ru.job4j.collection_final;

import java.util.Comparator;

public class DepDesComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String o1Result = "";
        String o2Result = "";
        int result;
        for (String value : o1.split("/")) {
            o1Result = value;
            break;
        }
        for (String value : o2.split("/")) {
            o2Result = value;
            break;
        }
        result = o2Result.compareTo(o1Result);
        if (result == 0) {
            return o1.compareTo(o2);
        }
        return result;
    }
}
