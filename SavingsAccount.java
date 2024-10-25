public class SavingsAccount extends BankAccount {
    double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = balance * interestRate;
        balance = balance + interest;
        System.out.println("Interest added. New balance: " + balance);
    }
}
