package ru.job4j.tracker;

public class StartUI {

    public void init (Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while(run) {
            this.showMenu(actions);
            int num = input.askInt("Select: ");
            UserAction action = actions[num];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ConsoleInput();
        UserAction[] actions = {new CreateAction(), new DeleteItem(), new EditItem(),
                new FindItemByID(), new FindItemByName(), new ShowAllItem(), new Exit()};
        new StartUI().init(input, tracker, actions);
    }
}
