package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input{
    private String[] answer;
    private int position = 0;

    public ConsoleInput(String[] answer) {
        this.answer = answer;
    }

    @Override
    public String askStr(String str) {
        return answer[position++];
    }

    @Override
    public int askInt(String str) {
        return Integer.parseInt(askStr(str));
    }
}
