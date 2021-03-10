package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        int result = -1;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getName().equals(login)) {
                result = 1;
                return users[i];
            }
        }
        if (result == -1) {
            throw new UserNotFoundException();
        }
        return null;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException();
        }
        if (user.getName().length() < 3) {
            throw new UserInvalidException();
        }
        return true;
    }

    public static void main(String[] args) throws UserNotFoundException, UserInvalidException {
        try {
            User[] users = {new User("Pe", true)
        };
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user access");
            }
        } catch (UserInvalidException t) {
            System.out.println("Пользователь не валиден");
        } catch (UserNotFoundException e) {
            System.out.println("Пользователь не найден");
        }
    }
}
