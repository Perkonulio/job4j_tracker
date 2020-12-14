package ru.job4j.sort;

import java.util.Arrays;

public class Machine {
    private final int[] coin = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] mass = new int[10];
        int exp = money - price;
        int size = 0;
        while(exp > 0) {
            for (int i = 0; i < coin.length; i++) {
                if(exp >= coin[i]) {
                    mass[size] = coin[i];
                    exp = exp - coin[i];
                    size++;
                    break;
                }
            }
        }
        return Arrays.copyOf(mass, size);
    }
}
