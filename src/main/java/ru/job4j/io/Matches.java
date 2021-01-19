package ru.job4j.io;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Игра 11");
        int count = 11;
        boolean turn = true;
        while(count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " " + "Сколько спичек вы хотите вытянуть? От 1 до 3");
            int playerInt = Integer.parseInt(scanner.nextLine());
            if(playerInt > 3) {
                System.out.println("По правилам запрещено брать больше 3 спичек за ход, " +
                        "\nпоэтому будем считать что вы опечатались и взяли 3 спички");
                count = count - 3;
                turn = !turn;
            } else {
                turn = !turn;
                count = count - playerInt;
            }
            System.out.println("Осталось " + count + " " + "спичек на столе");
        }
        if(turn) {
            System.out.println("Первый игрок победил");
        } else {
            System.out.println("Второй игрок победил");
        }
    }


}
