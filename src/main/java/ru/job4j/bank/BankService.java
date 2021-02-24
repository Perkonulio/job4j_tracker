package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if(!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> list = users.get(user);
        if(!list.contains(account)) {
            list.add(account);
            users.put(user, list);
        }
    }

    public User findByPassport(String passport) {
        for(User user : users.keySet()) {
            if(passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if(users.containsKey(user)) {
            for(Account account : users.get(user)) {
                if(account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport,
                                  String destRequisite, double amount) {
        User user1 = findByPassport(srcPassport);
        User user2 = findByPassport(destPassport);
        List<Account> list1 = users.get(user1);
        List<Account> list2= users.get(user2);
        Account account1 = findByRequisite(srcPassport, srcRequisite);
        Account account2 = findByRequisite(destPassport, destRequisite);
        if(list1.contains(account1) && account1.getBalance() >= amount) {
            account2.setBalance(amount + account2.getBalance());
            account1.setBalance(account1.getBalance() - amount);
            users.putIfAbsent(user1, list1);
            users.putIfAbsent(user2, list2);
        }
        return false;
    }





}
