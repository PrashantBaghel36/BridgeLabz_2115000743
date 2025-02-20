// Implement a Banking System
// Description:
// HashMap stores customer accounts (AccountNumber -> Balance).
// TreeMap sorts customers by balance.
// Queue processes withdrawal requests.


import java.util.*;

public class BankingSystem {
    private Map<String, Double> accounts = new HashMap<>();
    private TreeMap<Double, List<String>> sortedByBalance = new TreeMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();

    public void addAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedByBalance.putIfAbsent(balance, new ArrayList<>());
        sortedByBalance.get(balance).add(accountNumber);
    }

    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double oldBalance = accounts.get(accountNumber);
            sortedByBalance.get(oldBalance).remove(accountNumber);
            if (sortedByBalance.get(oldBalance).isEmpty()) {
                sortedByBalance.remove(oldBalance);
            }

            double newBalance = oldBalance + amount;
            accounts.put(accountNumber, newBalance);
            sortedByBalance.putIfAbsent(newBalance, new ArrayList<>());
            sortedByBalance.get(newBalance).add(accountNumber);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            if (accounts.get(accountNumber) >= amount) {
                withdrawalQueue.add(accountNumber);
            } else {
                System.out.println("Insufficient funds for account: " + accountNumber);
            }
        } else {
            System.out.println("Account not found!");
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            double amount = 50.0;  // Example fixed withdrawal amount
            if (accounts.get(accountNumber) >= amount) {
                double oldBalance = accounts.get(accountNumber);
                sortedByBalance.get(oldBalance).remove(accountNumber);
                if (sortedByBalance.get(oldBalance).isEmpty()) {
                    sortedByBalance.remove(oldBalance);
                }

                double newBalance = oldBalance - amount;
                accounts.put(accountNumber, newBalance);
                sortedByBalance.putIfAbsent(newBalance, new ArrayList<>());
                sortedByBalance.get(newBalance).add(accountNumber);

                System.out.println("Processed withdrawal of $" + amount + " for account: " + accountNumber);
            } else {
                System.out.println("Insufficient funds for withdrawal on account: " + accountNumber);
            }
        }
    }

    public void displayAccountsSortedByBalance() {
        System.out.println("\nAccounts sorted by balance:");
        for (Map.Entry<Double, List<String>> entry : sortedByBalance.entrySet()) {
            for (String account : entry.getValue()) {
                System.out.println("Account: " + account + " -> Balance: $" + entry.getKey());
            }
        }
    }

    public void displayAccounts() {
        System.out.println("\nAll Accounts:");
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            System.out.println("Account: " + entry.getKey() + " -> Balance: $" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAccount("A1001", 500.0);
        bank.addAccount("A1002", 1000.0);
        bank.addAccount("A1003", 750.0);
        bank.addAccount("A1004", 300.0);

        bank.displayAccounts();
        bank.displayAccountsSortedByBalance();

        bank.deposit("A1001", 200.0);
        bank.withdraw("A1002", 50.0);
        bank.withdraw("A1003", 100.0);
        bank.withdraw("A1004", 400.0); // Insufficient funds

        bank.processWithdrawals();

        bank.displayAccounts();
        bank.displayAccountsSortedByBalance();
    }
}
