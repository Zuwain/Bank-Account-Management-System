public class CheckingAccount extends BankAccount {
    double overdraftLimit;

    public CheckingAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance + overdraftLimit) {
            System.out.println("Exceeded overdraft limit!");
        } else {
            balance = balance - amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
            transactionHistory.add(new Transaction(this, amount, "Withdrawal"));
        }
    }
}