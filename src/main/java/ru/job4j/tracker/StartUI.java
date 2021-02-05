package ru.job4j.tracker;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init (Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while(run) {
            this.showMenu(actions);
            int num = input.askInt("Select: ");
            if(num < 0 || num >= actions.length) {
                out.println("Wrong input, u can select: 0.. " + (actions.length- 1));
                continue;
            }
            UserAction action = actions[num];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Tracker tracker = Tracker.getInstance();
        Input input = new ValidateInput(output, new ConsoleInput());
        UserAction[] actions = {new CreateAction(output), new DeleteItem(output), new EditItem(output),
                new FindItemByID(output), new FindItemByName(output), new ShowAllItem(output), new Exit()};
        new StartUI(output).init(input, tracker, actions);
    }
}
