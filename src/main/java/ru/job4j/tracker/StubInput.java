package ru.job4j.tracker;

public class StubInput implements Input{
    String[] answer;
    private int position = 0;

    public StubInput(String[] answer) {
        this.answer = answer;
    }

    public String askStr(String str) {
        return answer[position++];
    }

    @Override
    public int askInt(String str) {
        return Integer.parseInt(askStr(str));
    }
}
