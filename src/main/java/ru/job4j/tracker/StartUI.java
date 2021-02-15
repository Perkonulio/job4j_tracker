package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init (Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while(run) {
            this.showMenu(actions);
            int num = input.askInt("Select: ");
            if(num < 0 || num >= actions.size()) {
                out.println("Wrong input, u can select: 0.. " + (actions.size()- 1));
                continue;
            }
            UserAction action = actions.get(num);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu");
        for (int i = 0; i < actions.size(); i++) {
            System.out.println(i + ". " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Tracker tracker = Tracker.getInstance();
        Input input = new ValidateInput(output, new ConsoleInput());
        List<UserAction> actions = Arrays.asList( new CreateAction(output), new DeleteItem(output), new EditItem(output),
                new FindItemByID(output), new FindItemByName(output), new ShowAllItem(output), new Exit() );
        new StartUI(output).init(input, tracker, actions);
    }
}
