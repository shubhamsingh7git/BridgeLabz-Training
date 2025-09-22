package OOPs_DesignPrinciples.ObjectModelling;

import java.util.ArrayList;

class Customer {
    String name;
    ArrayList<Account> accounts = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Customer: " + name);
        for (Account acc : accounts) {
            System.out.println("Account in Bank: " + acc.bank.name + ", Balance: " + acc.balance);
        }
    }
}

class Bank {
    String name;

    public Bank(String name) {
        this.name = name;
    }

    public Account openAccount(Customer customer, double balance) {
        Account acc = new Account(this, balance);
        customer.addAccount(acc);
        return acc;
    }
}

class Account {
    Bank bank;
    double balance;

    public Account(Bank bank, double balance) {
        this.bank = bank;
        this.balance = balance;
    }
}

public class Q2 {
    public static void main(String[] args) {
        Bank b1 = new Bank("State Bank");
        Customer c1 = new Customer("Alice");
        Customer c2 = new Customer("Bob");

        b1.openAccount(c1, 5000);
        b1.openAccount(c2, 10000);

        c1.viewBalance();
        c2.viewBalance();
    }
}
