import java.util.Scanner;

public class BankSystemTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("SimpleBank");

        while (true) {
            System.out.println("\n------------------------------------------------------------------------------------------");
            String multiLineString = String.join("\n",
                ".______        ___      .__   __.  __  ___    .___  ___.  _______ .__   __.  __    __  \r\n" + 
                "|   _  \\      /   \\     |  \\ |  | |  |/  /    |   \\/   | |   ____||  \\ |  | |  |  |  | \r\n" + 
                "|  |_)  |    /  ^  \\    |   \\|  | |  '  /     |  \\  /  | |  |__   |   \\|  | |  |  |  | \r\n" + 
                "|   _  <    /  /_\\  \\   |  . `  | |    <      |  |\\/|  | |   __|  |  . `  | |  |  |  | \r\n" + 
                "|  |_)  |  /  _____  \\  |  |\\   | |  .  \\     |  |  |  | |  |____ |  |\\   | |  `--'  | \r\n" + 
                "|______/  /__/     \\__\\ |__| \\__| |__|\\__\\    |__|  |__| |_______||__| \\__|  \\______/  \r\n" + 
                "                                                                                        "
            );
            System.out.println(multiLineString);
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("Choose an option: ");
            System.out.println("1. Add Savings Account");
            System.out.println("2. Add Checking Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Remove Account");
            System.out.println("6. Check Balance");
            System.out.println("7. View Transaction History");
            System.out.println("8. Exit");
            System.out.println("------------------------------------------------------------------------------------------");

            int choice = InputValidator.getValidInteger("Enter your choice: ");

            if (choice == 8) {
                System.out.println("Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    String savingsAccNum;
                    while (true) {
                        savingsAccNum = InputValidator.getValidString("Account Number: ");
                        if (bank.findAccount(savingsAccNum) != null) {
                            System.out.println("Account with this number already exists. Please use a different account number.");
                        } else {
                            break; 
                        }
                    }
                    String savingsHolder = InputValidator.getValidString("Account Holder: ");
                    double savingsBalance = InputValidator.getValidDouble("Initial Balance: ");
                    double interestRate = InputValidator.getValidDouble("Interest Rate: ");
                    bank.addAccount(new SavingsAccount(savingsAccNum, savingsHolder, savingsBalance, interestRate));
                    break;

                case 2:
                    String checkingAccNum;
                    while (true) {
                        checkingAccNum = InputValidator.getValidString("Account Number: ");
                        if (bank.findAccount(checkingAccNum) != null) {
                            System.out.println("Account with this number already exists. Please use a different account number.");
                        } else {
                            break; 
                        }
                    }

                    String checkingHolder = InputValidator.getValidString("Account Holder: ");
                    double checkingBalance = InputValidator.getValidDouble("Initial Balance: ");
                    double overdraftLimit = InputValidator.getValidDouble("Overdraft Limit: ");
                    bank.addAccount(new CheckingAccount(checkingAccNum, checkingHolder, checkingBalance, overdraftLimit));
                    break;

                case 3:
                    String depositAccNum = InputValidator.getValidString("Account Number: ");
                    BankAccount depositAcc = bank.findAccount(depositAccNum);
                    if (depositAcc != null) {
                        double depositAmount = InputValidator.getValidDouble("Amount to Deposit: ");
                        depositAcc.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    String withdrawAccNum = InputValidator.getValidString("Account Number: ");
                    BankAccount withdrawAcc = bank.findAccount(withdrawAccNum);
                    if (withdrawAcc != null) {
                        double withdrawAmount = InputValidator.getValidDouble("Amount to Withdraw: ");
                        withdrawAcc.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    String removeAccNum = InputValidator.getValidString("Account Number to Remove: ");
                    bank.removeAccount(removeAccNum);
                    break;

                case 6:
                    String balanceAccNum = InputValidator.getValidString("Account Number: ");
                    BankAccount balanceAcc = bank.findAccount(balanceAccNum);
                    if (balanceAcc != null) {
                        System.out.println("Current Balance: " + balanceAcc.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 7:
                    String historyAccNum = InputValidator.getValidString("Account Number: ");
                    BankAccount historyAcc = bank.findAccount(historyAccNum);
                    if (historyAcc != null) {
                        historyAcc.viewTransactionHistory();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
