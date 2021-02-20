package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class NotifyAccount {
    public static HashSet<Account> sent(List<Account> listAccounts) {
        HashSet<Account> result = new HashSet<>();
        for (Account account : listAccounts) {
            result.add(account);
        }
        return result;
    }
}
