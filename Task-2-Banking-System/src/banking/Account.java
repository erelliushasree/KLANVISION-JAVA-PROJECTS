package banking;
import java.util.ArrayList;

public class Account {
    private ArrayList<Transaction> transactions;
    private String accountNumber;
    private String customerName;
    private String phoneNumber;
    private double balance;

    public Account(String accountNumber, String customerName,
                   String phoneNumber, double balance) {

        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.balance = balance;

        transactions = new ArrayList<>();

        transactions.add(
                new Transaction(
                        "ACCOUNT CREATED",
                        balance,
                        "Initial account balance"
                )
        );
    }
    public Account(String accountNumber,
                   String customerName,
                   String phoneNumber,
                   double balance,
                   boolean loadFromFile) {

        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.balance = balance;

        transactions = new ArrayList<>();

        if (!loadFromFile) {
            transactions.add(
                    new Transaction(
                            "ACCOUNT CREATED",
                            balance,
                            "Initial account balance"
                    )
            );
        }
    }

    public String getAccountNumber(){

        return accountNumber;
    }
    public String getCustomerName(){
        return customerName;
    }
    public String getPhoneNumber(){

        return phoneNumber;
    }
    public double getBalance(){

        return balance;
    }

    public void deposit(double amount) {

        if (amount > 0) {
            balance = balance + amount;

            transactions.add(
                    new Transaction(
                            "DEPOSIT",
                            amount,
                            "Money deposited"
                    )
            );
        }
    }
    public boolean withdraw(double amount) {

        if (amount > 0 && amount <= balance) {

            balance = balance - amount;

            transactions.add(
                    new Transaction(
                            "WITHDRAWAL",
                            amount,
                            "Money withdrawn"
                    )
            );

            return true;
        }

        return false;
    }
    public void showTransactionHistory() {

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        System.out.println("===== Transaction History =====");

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}
