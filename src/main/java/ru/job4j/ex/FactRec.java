package ru.job4j.ex;

public class FactRec {
    public static int factorio(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        return factorio(n - 1) * n;
    }

    public static void main(String[] args) {
        int result = factorio(3);
        System.out.println(result);
    }
}
