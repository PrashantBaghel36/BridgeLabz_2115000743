// Bank Class
class Bank {
    private String name;
    private Customer customer; // Single customer reference

    public Bank(String name) {
        this.name = name;
    }

    public void openAccount(Customer customer, double initialDeposit) {
        this.customer = customer;
        Account account = new Account(this, initialDeposit);
        customer.setAccount(account);
        System.out.println("Account opened for " + customer.getName() + " at " + this.name);
    }

    public String getName() {
        return name;
    }

    public Customer getCustomer() {
        return customer;
    }
}

// Customer Class
class Customer {
    private String name;
    private Account account; // Single account reference

    public Customer(String name) {
        this.name = name;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void viewBalance() {
        if (account != null) {
            System.out.println(name + "'s balance: $" + account.getBalance());
        } else {
            System.out.println(name + " has no account.");
        }
    }

    public String getName() {
        return name;
    }
}

// Account Class
class Account {
    private Bank bank;
    private double balance;

    public Account(Bank bank, double initialDeposit) {
        this.bank = bank;
        this.balance = initialDeposit;
    }

    public double getBalance() {
        return balance;
    }

    public Bank getBank() {
        return bank;
    }
}

// Main Class
public class BankSystem {
    public static void main(String[] args) {
        Bank bank = new Bank("ABC Bank");
        Customer customer = new Customer("John Doe");

        bank.openAccount(customer, 1000.0);
        customer.viewBalance();
    }
}

