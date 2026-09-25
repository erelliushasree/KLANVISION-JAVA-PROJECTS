package banking;

import java.util.Scanner;
import java.util.InputMismatchException;

public class BankingApp {
    public static void main(String[] args) {

        Bank bank = new Bank();

        bank.loadAccounts(
                FileManager.loadAccounts()
        );

        FileManager.loadTransactions(
                bank.getAccounts()
        );

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("===== KLANVISION BANK =====");
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Search Account");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. Transfer Money");
            System.out.println("7. Transaction History");
            System.out.println("8. Display All Accounts");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            int choice;

            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
                continue;
            }
            switch (choice) {
                case 1: {
                    System.out.println("Enter Account Number:");
                    String accountNumber = sc.next();

                    if (bank.accountExists(accountNumber)) {
                        System.out.println("Account number already exists.");
                        break;
                    }

                    System.out.println("Enter Customer Name:");
                    sc.nextLine();
                    String customerName = sc.nextLine().trim();

                    if (customerName.isEmpty()) {
                        System.out.println("Customer name cannot be empty.");
                        break;
                    }

                    System.out.println("Enter Phone Number:");
                    String phoneNumber = sc.next();

                    if (!phoneNumber.matches("\\d{10}")) {
                        System.out.println(
                                "Invalid phone number. Enter exactly 10 digits."
                        );
                        break;
                    }

                    System.out.println("Enter Initial Balance:");

                    double balance;

                    try {
                        balance = sc.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println(
                                "Invalid balance. Please enter a number."
                        );
                        sc.nextLine();
                        break;
                    }

                    if (balance < 0) {
                        System.out.println(
                                "Initial balance cannot be negative."
                        );
                        break;
                    }

                    Account account = new Account(
                            accountNumber,
                            customerName,
                            phoneNumber,
                            balance
                    );

                    bank.addAccount(account);

                    System.out.println("Account created successfully!");

                    break;
                }

                case 2:
                    System.out.println("Enter Account Number:");
                    String searchAccountNumber = sc.next();

                    Account foundAccount =
                            bank.findAccount(searchAccountNumber);

                    if (foundAccount != null) {
                        System.out.println("Account Number: "
                                + foundAccount.getAccountNumber());

                        System.out.println("Customer Name: "
                                + foundAccount.getCustomerName());

                        System.out.println("Phone Number: "
                                + foundAccount.getPhoneNumber());

                        System.out.println("Balance: "
                                + foundAccount.getBalance());
                    } else {
                        System.out.println("Account not found");
                    }
                    break;

                case 3: {
                    System.out.println("Enter customer name to search:");
                    String keyword = sc.next();

                    bank.searchAccounts(keyword);

                    break;
                }

                case 4:
                    System.out.println("Enter Account Number:");
                    String depositAccountNumber = sc.next();

                    Account depositAccount = bank.findAccount(depositAccountNumber);

                    if (depositAccount != null) {
                        System.out.println("Enter Deposit Amount:");
                        double amount;

                        try {
                            amount = sc.nextDouble();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid amount. Please enter a number.");
                            sc.nextLine();
                            break;
                        }

                        if (amount > 0) {
                            depositAccount.deposit(amount);
                            System.out.println("Amount deposited successfully!");
                            System.out.println("Updated Balance: "
                                    + depositAccount.getBalance());
                        } else {
                            System.out.println("Deposit amount must be greater than zero.");
                        }
                    } else {
                        System.out.println("Account not found");
                    }
                    break;

                case 5:
                    System.out.println("Enter Account Number:");
                    String withdrawAccountNumber = sc.next();

                    Account withdrawAccount =
                            bank.findAccount(withdrawAccountNumber);

                    if (withdrawAccount != null) {
                        System.out.println("Enter Withdrawal Amount:");
                        double amount;

                        try {
                            amount = sc.nextDouble();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid amount. Please enter a number.");
                            sc.nextLine();
                            break;
                        }

                        if (withdrawAccount.withdraw(amount)) {
                            System.out.println("Amount withdrawn successfully!");
                            System.out.println("Updated Balance: "
                                    + withdrawAccount.getBalance());
                        } else {
                            System.out.println(
                                    "Withdrawal failed. Check amount or available balance."
                            );
                        }
                    } else {
                        System.out.println("Account not found");
                    }
                    break;

                case 6:
                    System.out.println("Enter Sender Account Number:");
                    String fromAccountNumber = sc.next();

                    System.out.println("Enter Receiver Account Number:");
                    String toAccountNumber = sc.next();

                    System.out.println("Enter Transfer Amount:");

                    double amount;

                    try {
                        amount = sc.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println(
                                "Invalid amount. Please enter a number."
                        );
                        sc.nextLine();
                        break;
                    }

                    if (bank.transfer(fromAccountNumber, toAccountNumber, amount)) {
                        System.out.println("Money transferred successfully!");

                        Account sender = bank.findAccount(fromAccountNumber);
                        Account receiver = bank.findAccount(toAccountNumber);

                        System.out.println("Sender Balance: "
                                + sender.getBalance());

                        System.out.println("Receiver Balance: "
                                + receiver.getBalance());
                    } else {
                        System.out.println(
                                "Transfer failed. Check account numbers, amount, or balance."
                        );
                    }
                    break;

                case 7: {
                    System.out.println("Enter Account Number:");
                    String historyAccountNumber = sc.next();

                    Account historyAccount =
                            bank.findAccount(historyAccountNumber);

                    if (historyAccount != null) {
                        historyAccount.showTransactionHistory();
                    } else {
                        System.out.println("Account not found");
                    }

                    break;
                }

                case 8: {
                    bank.displayAllAccounts();
                    break;
                }
                case 9: {
                    FileManager.saveAccounts(bank.getAccounts());
                    FileManager.saveTransactions(bank.getAccounts());

                    System.out.println("Thank you for using KLANVISION BANK");

                    sc.close();
                    return;
                }

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}