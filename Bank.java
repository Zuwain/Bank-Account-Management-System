import java.util.ArrayList;

public class Bank {
    String name;
    ArrayList<BankAccount> accounts;
    ArrayList<Transaction> transactions;
    int transactionIdCounter = 1;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        BankAccount existingAccount = findAccount(account.accountNumber);
        if (existingAccount != null) {
            return;
        }

        accounts.add(account);
        System.out.println("Account added: " + account.accountNumber);
    }
    
    

    public void removeAccount(String accountNumber) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).accountNumber.equals(accountNumber)) {
                accounts.remove(i);
                System.out.println("Account removed: " + accountNumber);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.accountNumber.equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public ArrayList<BankAccount> getAllAccounts() {
        return accounts;
    }
}
