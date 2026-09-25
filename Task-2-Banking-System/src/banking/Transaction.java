package banking;

import java.time.LocalDateTime;

public class Transaction {

    private String type;
    private double amount;
    private LocalDateTime dateTime;
    private String description;

    public Transaction(String type, double amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.dateTime = LocalDateTime.now();
    }
    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return dateTime
                + " | "
                + type
                + " | Amount: "
                + amount
                + " | "
                + description;
    }
    public Transaction(String type,
                       double amount,
                       String description,
                       LocalDateTime dateTime) {

        this.type = type;
        this.amount = amount;
        this.description = description;
        this.dateTime = dateTime;
    }

}