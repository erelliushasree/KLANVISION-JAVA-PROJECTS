package banking;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void loadAccounts(ArrayList<Account> loadedAccounts) {
        accounts.addAll(loadedAccounts);
    }

    public boolean accountExists(String accountNumber) {

        for (Account account : accounts) {

            if (account.getAccountNumber().equals(accountNumber)) {
                return true;
            }
        }

        return false;
    }

    public Account findAccount(String accountNumber) {

        for (Account account : accounts) {

            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }

        return null;
    }

    public void searchAccounts(String keyword) {

        boolean found = false;

        for (Account account : accounts) {

            if (account.getCustomerName()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())) {

                System.out.println("Account Number: "
                        + account.getAccountNumber());

                System.out.println("Customer Name: "
                        + account.getCustomerName());

                System.out.println("Phone Number: "
                        + account.getPhoneNumber());

                System.out.println("Balance: "
                        + account.getBalance());

                System.out.println("-------------------------");

                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching accounts found.");
        }
    }
    public void displayAllAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.println("===== All Bank Accounts =====");

        for (Account account : accounts) {

            System.out.println("Account Number: "
                    + account.getAccountNumber());

            System.out.println("Customer Name: "
                    + account.getCustomerName());

            System.out.println("Phone Number: "
                    + account.getPhoneNumber());

            System.out.println("Balance: "
                    + account.getBalance());

            System.out.println("-------------------------");
        }
    }

    public boolean transfer(String fromAccountNumber,
                            String toAccountNumber,
                            double amount) {

        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);

        if (fromAccount == null || toAccount == null) {
            return false;
        }

        if (fromAccountNumber.equals(toAccountNumber)) {
            return false;
        }

        if (amount <= 0 || !fromAccount.withdraw(amount)) {
            return false;
        }

        toAccount.deposit(amount);

        return true;
    }
}