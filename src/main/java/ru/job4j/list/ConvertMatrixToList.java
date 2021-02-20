package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrixToList {
    public List<Integer> toList(int[][] array) {
        List<Integer> listNumbers = new ArrayList<>();
        for (int[] row : array) {
            for (int cell : row) {
                listNumbers.add(cell);
            }
        }
        return listNumbers;
    }
}
