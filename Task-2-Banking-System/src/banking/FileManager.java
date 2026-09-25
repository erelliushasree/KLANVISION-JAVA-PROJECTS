package banking;

import java.io.*;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class FileManager {

    private static final String FILE_NAME = "accounts.txt";
    private static final String TRANSACTION_FILE_NAME = "transactions.txt";

    public static void saveAccounts(ArrayList<Account> accounts) {

        try (PrintWriter writer =
                     new PrintWriter(new FileWriter(FILE_NAME))) {

            for (Account account : accounts) {

                writer.println(
                        account.getAccountNumber() + "," +
                                account.getCustomerName() + "," +
                                account.getPhoneNumber() + "," +
                                account.getBalance()
                );
            }

            System.out.println("Accounts saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving accounts.");
        }
    }

    public static ArrayList<Account> loadAccounts() {

        ArrayList<Account> accounts = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return accounts;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 4) {

                    String accountNumber = data[0];
                    String customerName = data[1];
                    String phoneNumber = data[2];
                    double balance = Double.parseDouble(data[3]);

                    Account account = new Account(
                            accountNumber,
                            customerName,
                            phoneNumber,
                            balance,
                            true
                    );


                    accounts.add(account);
                }
            }

            System.out.println("Accounts loaded successfully.");

        } catch (IOException | NumberFormatException e) {

            System.out.println("Error loading accounts.");
        }

        return accounts;
    }
    public static void saveTransactions(ArrayList<Account> accounts) {

        try (PrintWriter writer =
                     new PrintWriter(new FileWriter(TRANSACTION_FILE_NAME))) {

            for (Account account : accounts) {

                for (Transaction transaction : account.getTransactions()) {

                    writer.println(
                            account.getAccountNumber() + "|" +
                                    transaction.getType() + "|" +
                                    transaction.getAmount() + "|" +
                                    transaction.getDescription() + "|" +
                                    transaction.getDateTime()
                    );
                }
            }

            System.out.println("Transaction history saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving transaction history.");
        }
    }
    public static void loadTransactions(ArrayList<Account> accounts) {

        File file = new File(TRANSACTION_FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                if (data.length == 5) {

                    String accountNumber = data[0];
                    String type = data[1];
                    double amount = Double.parseDouble(data[2]);
                    String description = data[3];

                    Account account = null;

                    for (Account currentAccount : accounts) {

                        if (currentAccount.getAccountNumber()
                                .equals(accountNumber)) {

                            account = currentAccount;
                            break;
                        }
                    }

                    if (account != null) {

                        LocalDateTime dateTime =
                                LocalDateTime.parse(data[4]);

                        Transaction transaction =
                                new Transaction(
                                        type,
                                        amount,
                                        description,
                                        dateTime
                                );


                        account.addTransaction(transaction);
                    }
                }
            }

            System.out.println(
                    "Transaction history loaded successfully."
            );

        } catch (IOException | NumberFormatException e) {

            System.out.println(
                    "Error loading transaction history."
            );
        }
    }
}