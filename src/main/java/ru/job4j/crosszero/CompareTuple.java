package ru.job4j.crosszero;

import java.util.Comparator;

public class CompareTuple implements Comparator<Tuple> {

    @Override
    public int compare(Tuple o1, Tuple o2) {
        return Double.compare(o1.getScore(), o2.getScore());
    }
}
