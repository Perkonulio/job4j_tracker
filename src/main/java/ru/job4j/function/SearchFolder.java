package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {

    public static List<Folder> filterList(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> allFilterList = new ArrayList<>();
        for (Folder folder : list) {
            if (pred.test(folder)) {
                allFilterList.add(folder);
            }
        }
        return allFilterList;
    }
}
