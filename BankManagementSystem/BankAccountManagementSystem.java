package BankManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccountManagementSystem {
    private List<BankAccount> accounts;
    private Scanner scanner;

    public BankAccountManagementSystem() {
        accounts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        BankAccountManagementSystem system = new BankAccountManagementSystem();
        system.run();
    }

    private void run() {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = getChoice();
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositToAccount();
                    break;
                case 3:
                    withdrawFromAccount();
                    break;
                case 4:
                    displayAccountDetails();
                    break;
                case 5:
                    deleteAccount();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private void printMenu() {
        System.out.println("\nBank Account Management System");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit to Account");
        System.out.println("3. Withdraw from Account");
        System.out.println("4. Display Account Details");
        System.out.println("5. Delete Account");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getChoice() {
        int choice = -1;
        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Clear the invalid input
        }
        return choice;
    }

    private void createAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.next();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        BankAccount account = new BankAccount(accountNumber, accountHolderName, initialBalance);
        accounts.add(account);
        System.out.println("Account created successfully.");
    }

    private void depositToAccount() {
        BankAccount account = findAccount();
        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        }
    }

    private void withdrawFromAccount() {
        BankAccount account = findAccount();
        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        }
    }

    private void displayAccountDetails() {
        BankAccount account = findAccount();
        if (account != null) {
            System.out.println(account);
        }
    }

    private void deleteAccount() {
        BankAccount account = findAccount();
        if (account != null) {
            accounts.remove(account);
            System.out.println("Account deleted successfully.");
        }
    }

    private BankAccount findAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        System.out.println("Account not found.");
        return null;
    }
}
