// Create a BankAccount class with:
// accountNumber (public).
// accountHolder (protected).
// balance (private).
// Write methods to:
// Access and modify balance using public methods.
// Create a subclass SavingsAccount to demonstrate access to accountNumber and accountHolder.


class BankAccount {
    public int accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(int accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void displayAccountDetails() {
        System.out.println("Savings Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1001, "John Doe", 5000.0);
        System.out.println("Balance: " + account.getBalance());
        account.setBalance(6000.0);
        System.out.println("Updated Balance: " + account.getBalance());

        SavingsAccount savings = new SavingsAccount(2002, "Alice Smith", 7000.0);
        savings.displayAccountDetails();
    }
}
