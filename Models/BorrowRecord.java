package Models;

import java.time.LocalDate;


public class BorrowRecord {
    private String recordId;
    private String borrowerId;  
    private String borrowerRole; 
    private String isbn;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public BorrowRecord(String recordId, String borrowerId, String borrowerRole, String isbn, LocalDate borrowDate, LocalDate dueDate) {
        this.recordId = recordId;
        this.borrowerId = borrowerId;
        this.borrowerRole = borrowerRole;
        this.isbn = isbn;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = null;
    }

    public String getRecordId() { return recordId; }
    public String getBorrowerId() { return borrowerId; }
    public String getBorrowerRole() { return borrowerRole; }
    public String getIsbn() { return isbn; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }

    public void setReturnDate(LocalDate date) { this.returnDate = date; }

    public boolean isOverdue() {
        LocalDate checkDate = (returnDate == null) ? LocalDate.now() : returnDate;
        return checkDate.isAfter(dueDate);
    }

    public long overdueDays() {
        LocalDate checkDate = (returnDate == null) ? LocalDate.now() : returnDate;
        if (!checkDate.isAfter(dueDate)) return 0;
        return java.time.temporal.ChronoUnit.DAYS.between(dueDate, checkDate);
    }

    @Override
    public String toString() {
        return String.format("BorrowRecord[%s] borrower=%s role=%s isbn=%s borrowed=%s due=%s returned=%s",
            recordId, borrowerId, borrowerRole, isbn, borrowDate, dueDate, returnDate);
    }
}
