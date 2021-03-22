package ru.job4j.collection_final;

import java.util.*;

public class Departaments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String values : deps) {
            String start = "";
            for (String element : values.split("/")) {
                if (start.equals("")) {
                    start += element;
                } else {
                    start += "/" + element;
                }
                tmp.add(start);
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDesComp());
    }
}
