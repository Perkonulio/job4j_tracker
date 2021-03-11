package ru.job4j.bank;

import java.util.*;

public class BankService {

    /**
     * Аккаунты связанные с User хранятся в коллекции типа HashMap.
     */
    private Map<User, List<Account>> users = new HashMap<>();


    /**
     * Метод принимает на вход пользователя
     * и добавляет его в HashMap, если его там нет.
     * @param user пользователь который добавляется в HashMap.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход номер паспорта от User,
     * и аккаунт который нужно добавить
     * в список аккаунтов привязанных к User, если его там нет.
     * @param passport номер паспорта по которому идет поиск пользователя
     * @param account аккаунт который необходимо добавить
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод который осуществляет поиск ползователя по номеру паспорта.
     * @param passport номер паспорта для осуществления поиска по HashMap
     * @return возвращает пользователя из HashMap, если он там есть
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод осуществляет поиск аккаунта
     * по реквизитам и пользователю привязанных к аккаунту.
     * @param passport номер паспорта для осуществления поиска по HashMap
     * @param requisite реквизиты связанные с аккаунтом, для поиска последнего
     * @return возвращает аккаунт из HashMap, если он там есть
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод осуществляет перевод средств по реквизитам и номеру пасспорта,
     * с одного аккаунта на другой.
     * @param srcPassport номер паспорта по которому осуществляется поиск аккаунта
     * @param srcRequisite реквизиты привязанные к аккаунту С КОТОРЫХ необходимо перевести средства
     * @param destPassport номер паспорта по которму осуещствляется поиск второго аккаунта
     * @param destRequisite реквизиты привязанные ко второму аккаунту НА КОТОРЫЙ необходимо перевести средства
     * @param amount указываемая сумма средств для перевода
     * @return возвращает результат перевода средств
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport,
                                  String destRequisite, double amount) {
        Account account1 = findByRequisite(srcPassport, srcRequisite);
        Account account2 = findByRequisite(destPassport, destRequisite);
        if (account1 != null && account2 != null && account1.getBalance() >= amount) {
            account2.setBalance(amount + account2.getBalance());
            account1.setBalance(account1.getBalance() - amount);
        }
        return false;
    }
}
