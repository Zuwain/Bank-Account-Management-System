import java.util.Random;

public class Transaction {
    String transactionId;
    BankAccount account;
    double amount;
    String transactionType;

    public Transaction(BankAccount account, double amount, String transactionType) {
        this.transactionId = generateTransactionId();
        this.account = account;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    private String generateTransactionId() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public void displayTransaction() {
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Account Number: " + account.accountNumber);
        System.out.println("Amount: " + amount);
        System.out.println("Type: " + transactionType);
    }
}