import java.util.Scanner;

class Account {
    int accountNumber;
    String name;
    double balance;

    Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }
}

public class AccountManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static Account[] accounts = new Account[100];
    static int count = 0;

  
    static void createAccount() {
        System.out.print("Enter Account Number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        accounts[count] = new Account(accountNumber, name, balance);
        count++;

        System.out.println("Account created successfully!");
    }

   
    static void viewAccounts() {
        if (count == 0) {
            System.out.println("No accounts found.");
            return;
        }

        System.out.println("\n===== ACCOUNT LIST =====");

        for (int i = 0; i < count; i++) {
            System.out.println("Account Number : " + accounts[i].accountNumber);
            System.out.println("Name           : " + accounts[i].name);
            System.out.println("Balance        : " + accounts[i].balance);
            System.out.println("------------------------");
        }
    }

   
    static void deposit() {
        System.out.print("Enter Account Number: ");
        int number = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (accounts[i].accountNumber == number) {

                System.out.print("Enter Amount to Deposit: ");
                double amount = sc.nextDouble();

                if (amount > 0) {
                    accounts[i].balance += amount;
                    System.out.println("Amount deposited successfully!");
                    System.out.println("New Balance: " + accounts[i].balance);
                } else {
                    System.out.println("Invalid amount!");
                }
                return;
            }
        }

        System.out.println("Account not found.");
    }

  
    static void withdraw() {
        System.out.print("Enter Account Number: ");
        int number = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (accounts[i].accountNumber == number) {

                System.out.print("Enter Amount to Withdraw: ");
                double amount = sc.nextDouble();

                if (amount <= 0) {
                    System.out.println("Invalid amount!");
                } else if (amount > accounts[i].balance) {
                    System.out.println("Insufficient balance!");
                } else {
                    accounts[i].balance -= amount;
                    System.out.println("Amount withdrawn successfully!");
                    System.out.println("Remaining Balance: "
                            + accounts[i].balance);
                }
                return;
            }
        }

        System.out.println("Account not found.");
    }

   
    static void checkBalance() {
        System.out.print("Enter Account Number: ");
        int number = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (accounts[i].accountNumber == number) {
                System.out.println("Account Holder: " + accounts[i].name);
                System.out.println("Balance: " + accounts[i].balance);
                return;
            }
        }

        System.out.println("Account not found.");
    }

   
    static void accountDetails() {
        System.out.print("Enter Account Number: ");
        int number = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (accounts[i].accountNumber == number) {
                System.out.println("\n===== ACCOUNT DETAILS =====");
                System.out.println("Account Number : " + accounts[i].accountNumber);
                System.out.println("Account Holder : " + accounts[i].name);
                System.out.println("Balance        : " + accounts[i].balance);
                return;
            }
        }

        System.out.println("Account not found.");
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== ACCOUNT MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Account Details");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createAccount();
                    break;

                case 2:
                    viewAccounts();
                    break;

                case 3:
                    deposit();
                    break;

                case 4:
                    withdraw();
                    break;

                case 5:
                    checkBalance();
                    break;

                case 6:
                    accountDetails();
                    break;

                case 7:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
