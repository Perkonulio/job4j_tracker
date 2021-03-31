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
     *
     * @param user пользователь который добавляется в HashMap.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход номер паспорта от User,
     * и аккаунт который нужно добавить
     * в список аккаунтов привязанных к User, если его там нет.
     *
     * @param passport номер паспорта по которому идет поиск пользователя
     * @param account  аккаунт который необходимо добавить
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> list = users.get(user.get());
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод который осуществляет поиск ползователя по номеру паспорта.
     *
     * @param passport номер паспорта для осуществления поиска по HashMap
     * @return возвращает пользователя из HashMap, если он там есть
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод осуществляет поиск аккаунта
     * по реквизитам и пользователю привязанных к аккаунту.
     *
     * @param passport  номер паспорта для осуществления поиска по HashMap
     * @param requisite реквизиты связанные с аккаунтом, для поиска последнего
     * @return возвращает аккаунт из HashMap, если он там есть
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
    }

    /**
     * Метод осуществляет перевод средств по реквизитам и номеру пасспорта,
     * с одного аккаунта на другой.
     *
     * @param srcPassport   номер паспорта по которому осуществляется поиск аккаунта
     * @param srcRequisite  реквизиты привязанные к аккаунту С КОТОРЫХ необходимо перевести средства
     * @param destPassport  номер паспорта по которму осуещствляется поиск второго аккаунта
     * @param destRequisite реквизиты с второго аккаунта НА КОТОРЫЙ необходимо перевести средства
     * @param amount        указываемая сумма средств для перевода
     * @return возвращает результат перевода средств
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport,
                                 String destRequisite, double amount) {
        Optional<Account> account1 = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> account2 = findByRequisite(destPassport, destRequisite);
        if (account1.isPresent() && account2.isPresent() && account1.get().getBalance() >= amount) {
            account2.get().setBalance(amount + account2.get().getBalance());
            account1.get().setBalance(account1.get().getBalance() - amount);
        }
        return false;
    }
}
