package Models;

import java.time.LocalDate;

public class Payment {
    private String paymentId;
    private String payerId;     
    private double amount;
    private LocalDate date;
    private String description; 

    public Payment(String paymentId, String payerId, double amount, LocalDate date, String description) {
        this.paymentId = paymentId;
        this.payerId = payerId;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public String getPaymentId() { return paymentId; }
    public String getPayerId() { return payerId; }
    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "Payment[" + paymentId + "] payer=" + payerId + " amount=" + amount + " date=" + date + " desc=" + description;
    }
}
