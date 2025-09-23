package JavaPillars;
import java.util.*;

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) { 
        this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Invalid withdrawal or insufficient balance.");
        }
    }
    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * (interestRate / 100);
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings Account Loan Applied for: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 5000; // Eligible if balance ≥ 5000
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.02; 
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Current Account Loan Applied for: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() + overdraftLimit >= 10000; 
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}

public class Q4{
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        BankAccount acc1 = new SavingsAccount("SAV123", "Shubham", 8000, 4.5);
        BankAccount acc2 = new CurrentAccount("CUR456", "Saul", 3000, 7000);

        accounts.add(acc1);
        accounts.add(acc2);

        for (BankAccount acc : accounts) {
            System.out.println(" ");
            acc.displayDetails();
            System.out.println("Interest Earned: " + acc.calculateInterest());

            if (acc instanceof Loanable) {
                Loanable loanable = (Loanable) acc;
                loanable.applyForLoan(20000);
                System.out.println("Loan Eligibility: " + (loanable.calculateLoanEligibility() ? "Eligible" : "Not Eligible"));
            }
        }
    }
}
