abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    private BankAccount next;

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

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        }
    }

    public abstract double calculateInterest();

    public BankAccount getNext() {
        return next;
    }

    public void setNext(BankAccount next) {
        this.next = next;
    }
}

interface Loanable {
    boolean applyForLoan(double amount);

    double calculateLoanEligibility();
}

class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.02;
    private double loanLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double loanLimit) {
        super(accountNumber, holderName, balance);
        this.loanLimit = loanLimit;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    @Override
    public boolean applyForLoan(double amount) {
        return amount <= loanLimit;
    }

    @Override
    public double calculateLoanEligibility() {
        return loanLimit * 0.8;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SAV123", "John Doe", 5000);
        CurrentAccount current = new CurrentAccount("CUR456", "Jane Doe", 10000, 5000);

        savings.setNext(current);

        BankAccount account = savings;
        while (account != null) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Holder Name: " + account.getHolderName());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("Interest Earned: " + account.calculateInterest());

            if (account instanceof Loanable) {
                Loanable loanableAccount = (Loanable) account;
                System.out.println("Loan Eligibility: " + loanableAccount.calculateLoanEligibility());
            }
            System.out.println("----------------------------");
            account = account.getNext();
        }
    }
}
