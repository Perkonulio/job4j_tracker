package ru.job4j.collection_final;

import java.util.*;

public class Departaments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String values : deps) {
            String start = "";
            boolean averageElement = false;
            for (String element : values.split("/")) {
                if (!element.contains("s")) {//добавляет первый элемент К1
                    tmp.add(element);
                    start = element;
                } else if (!element.contains("ss")) {
                    tmp.add(start + "/" + element);//добавляет 2 уровень К1/SK1
                    start = start + "/" + element;
                    averageElement = true;//Флаг, указывающий на наличие 2 уровня
                } else if (element.contains("ss")
                        && !averageElement) {
                    tmp.add(start + "/" + "s" + start);//Добавление 2 уровня K1/SK1
                    start = start + "/" + "s" + start;
                    tmp.add(start + "/" + element);//Добавление 3 уровня K1/SK1/SSK1
                } else {
                    tmp.add(start + "/" + element);
                }
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {

    }

    public static void sortDesc(List<String> orgs) {

    }
}
