package ru.job4j.collection;

import java.util.List;

public class ConvertListToArray {
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size()/ cells);
        int[][] array = new int[groups][cells];
        int row = 0, cell = 0;
        for(Integer number : list) {
            if(row < groups) {
                if(cell < cells) {
                    array[row][cell] = number;
                    cell++;
                } else {
                    cell = 0;
                    row++;
                    array[row][cell] = number;
                    cell++;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int[][] result = toArray(list, 2);
        for(int[] row: result) {
            for(int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }



    }
}
