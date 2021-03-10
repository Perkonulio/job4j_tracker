package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String str) {
        System.out.println(str);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String str) {
        return Integer.parseInt(askStr(str));
    }
}
