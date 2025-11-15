package Models;

import java.time.LocalDate;
import java.util.UUID;

public class Invoice {
    private String invoiceId;
    private String studentId;
    private double amount;
    private LocalDate issuedDate;
    private boolean paid;

    public Invoice(String studentId, double amount) {
        this.invoiceId = "INV-" + UUID.randomUUID().toString().substring(0,8);
        this.studentId = studentId;
        this.amount = amount;
        this.issuedDate = LocalDate.now();
        this.paid = false;
    }

    public String getInvoiceId() { return invoiceId; }
    public String getStudentId() { return studentId; }
    public double getAmount() { return amount; }
    public LocalDate getIssuedDate() { return issuedDate; }
    public boolean isPaid() { return paid; }

    public void markPaid() { paid = true; }

    @Override
    public String toString() {
        return "Invoice[" + invoiceId + "] student=" + studentId + " amount=" + amount + " paid=" + paid;
    }
}
