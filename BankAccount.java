import java.util.ArrayList;

public class BankAccount implements IDeposit, IWithdraw, ICheckBalance, IViewTransaction {
    String accountNumber;
    String accountHolder;
    double balance;
    ArrayList<Transaction> transactionHistory;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    @Override
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println(amount + " deposited. New balance: " + balance);
        transactionHistory.add(new Transaction(this, amount, "Deposit"));
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance = balance - amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
            transactionHistory.add(new Transaction(this, amount, "Withdrawal"));
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void viewTransactionHistory() {
        System.out.println("Transaction History for Account: " + accountNumber);
        for (Transaction t : transactionHistory) {
            t.displayTransaction();
        }
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        }
    }
}