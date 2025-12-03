import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class BankAccount {
    String accountHolderName;
    String accountNumber;
    int pin;
    double balance;
    double dailyWithdrawalLimit = 100000;
    double dailyWithdrawnAmount = 100;

    BankAccount(String name, String accNumber, int pin, double initialBalance) {
        this.accountHolderName = name;
        this.accountNumber = accNumber;
        this.pin = pin;
        this.balance = initialBalance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("\nDeposit successful.");
            printReceipt("Deposit", amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            if (dailyWithdrawnAmount + amount <= dailyWithdrawalLimit) {
                balance -= amount;
                dailyWithdrawnAmount += amount;
                System.out.println("\nWithdrawal successful.");
                printReceipt("Withdrawal", amount);
            } else {
                System.out.println("Daily withdrawal limit exceeded. You can withdraw up to ₹" +
                        (dailyWithdrawalLimit - dailyWithdrawnAmount));
            }
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    void checkBalance() {
        System.out.println("\nAvailable Balance: ₹" + balance);
    }

    void changePin(int newPin) {
        this.pin = newPin;
        System.out.println("PIN changed successfully.");
    }

    void resetDailyLimit() {
        this.dailyWithdrawnAmount = 0;
    }

    void printReceipt(String transactionType, double amount) {
        System.out.println("\n--- Transaction Receipt ---");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println("Date/Time   : " + formatter.format(date));
        System.out.println("Transaction : " + transactionType);
        System.out.println("Amount      : ₹" + amount);
        System.out.println("Remaining Balance: ₹" + balance);
        System.out.println("******************************");
    }
}

public class ATMSimulation {
    static ArrayList<BankAccount> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n==== ATM Home Screen ====");
            System.out.println("1. Create Account");
            System.out.println("2. Insert Card (Login)");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    insertCard();
                    break;
                case 3:
                    System.out.println("\nThank you for using our ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 3);

        sc.close();
    }

    static void createAccount() {
        System.out.print("\nEnter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Account Number: ");
        String accNumber = sc.nextLine();
        System.out.print("Set 4-digit PIN: ");
        int pin = sc.nextInt();
        System.out.print("Enter Initial Deposit: ₹");
        double initialBalance = sc.nextDouble();
        sc.nextLine();

        BankAccount newAccount = new BankAccount(name, accNumber, pin, initialBalance);
        accounts.add(newAccount);
        System.out.println("Account created successfully!");
    }

    static BankAccount findAccount(String accNumber, int pin) {
        for (BankAccount acc : accounts) {
            if (acc.accountNumber.equals(accNumber) && acc.pin == pin) {
                return acc;
            }
        }
        return null;
    }

    static void insertCard() {
        System.out.print("\nEnter Account Number: ");
        String accNumber = sc.nextLine();
        System.out.print("Enter 4-digit PIN: ");
        int pin = sc.nextInt();
        sc.nextLine();

        BankAccount account = findAccount(accNumber, pin);
        if (account != null) {
            System.out.println("\nAuthentication Successful. Welcome, " + account.accountHolderName + "!");
            atmMenu(account);
        } else {
            System.out.println("\nAuthentication Failed. Please try again.");
        }
    }

    static void atmMenu(BankAccount account) {
        int choice;
        do {
            System.out.println("\n==== ATM Menu ====");
            System.out.println("1. Withdraw Cash");
            System.out.println("2. Deposit Cash");
            System.out.println("3. Balance Inquiry");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit (Remove Card)");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter amount to withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();
                    sc.nextLine();
                    account.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("\nEnter amount to deposit: ₹");
                    double depositAmount = sc.nextDouble();
                    sc.nextLine();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    System.out.print("\nEnter Old 4-digit PIN: ");
                    int oldPin = sc.nextInt();
                    sc.nextLine();
                    if (oldPin == account.pin) {
                        System.out.print("Enter New 4-digit PIN: ");
                        int newPin = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Confirm New 4-digit PIN: ");
                        int confirmPin = sc.nextInt();
                        sc.nextLine();
                        if (newPin == confirmPin) {
                            account.changePin(newPin);
                        } else {
                            System.out.println("PINs do not match. PIN change failed.");
                        }
                    } else {
                        System.out.println("Old PIN is incorrect. PIN change failed.");
                    }
                    break;
                case 5:
                    System.out.println("\nCard removed. Thank you for using our ATM!");
                    account.resetDailyLimit();
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (choice != 5);
    }
}
