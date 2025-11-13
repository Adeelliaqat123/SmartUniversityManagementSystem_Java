package Managers;

import Models.*;
import java.time.LocalDate;
import java.util.*;


public class LibraryManager {
    private Library library;
    private Map<String, Integer> borrowerActiveCount = new HashMap<>();
    private double finePerDay = 10.0; 

    public LibraryManager(Library library) {
        this.library = library;
    }

    
    private int getBorrowLimit(String role) {
        if (role == null) return 0;
        switch (role.toLowerCase()) {
            case "faculty":
            case "professor":
            case "assistant professor":
            case "lecturer":
                return 20;
            case "phd student":
                return 7; 
            case "graduate student":
                return 7;
            case "student":
            case "undergraduate student":
                return 5;
            case "staff":
            default:
                return 5;
        }
    }

    private int getLoanDays(String role) {
        if (role == null) return 14;
        switch (role.toLowerCase()) {
            case "faculty":
            case "professor":
            case "assistant professor":
            case "lecturer":
                return 60;
            case "phd student":
                return 30; 
            case "graduate student":
                return 30;
            case "student":
            case "undergraduate student":
                return 14;
            case "staff":
            default:
                return 21;
        }
    }

    public boolean borrowBook(String borrowerId, String borrowerRole, String isbn) {
        
        int current = borrowerActiveCount.getOrDefault(borrowerId, 0);
        int limit = getBorrowLimit(borrowerRole);

        if (current >= limit) {
            System.out.println("Borrow limit reached for " + borrowerId + " (role " + borrowerRole + ")");
            return false;
        }

        Book b = library.findByISBN(isbn);
        if (b == null) {
            System.out.println("Book not found: " + isbn);
            return false;
        }
        if (!b.borrowCopy()) {
            System.out.println("No copies available for " + b.getTitle());
            return false;
        }

        LocalDate borrowDate = LocalDate.now();
        LocalDate dueDate = borrowDate.plusDays(getLoanDays(borrowerRole));
        String recordId = UUID.randomUUID().toString();
        BorrowRecord r = new BorrowRecord(recordId, borrowerId, borrowerRole, isbn, borrowDate, dueDate);
        library.addBorrowRecord(r);
        borrowerActiveCount.put(borrowerId, current + 1);
        System.out.println("Book borrowed: " + b.getTitle() + " by " + borrowerId + " due " + dueDate);
        return true;
    }

    public boolean returnBook(String borrowerId, String isbn) {
        BorrowRecord r = library.findActiveRecord(borrowerId, isbn);
        if (r == null) {
            System.out.println("No active borrow record for borrower " + borrowerId + " and book " + isbn);
            return false;
        }
        LocalDate returnDate = LocalDate.now();
        r.setReturnDate(returnDate);

        Book b = library.findByISBN(isbn);
        if (b != null) b.returnCopy();

        
        int current = borrowerActiveCount.getOrDefault(borrowerId, 1);
        borrowerActiveCount.put(borrowerId, Math.max(0, current - 1));

        
        long overdueDays = r.overdueDays();
        if (overdueDays > 0) {
            double fine = overdueDays * finePerDay;
            System.out.println("Book returned late by " + overdueDays + " days. Fine = " + fine);
        } else {
            System.out.println("Book returned on time. Thank you.");
        }
        return true;
    }

    public double calculateFine(String borrowerId) {
        double total = 0.0;
        for (BorrowRecord r : library.getBorrowRecords()) {
            if (r.getBorrowerId().equals(borrowerId) && r.getReturnDate() == null) {
                total += r.overdueDays() * finePerDay;
            }
        }
        return total;
    }

    public void listAvailableBooks() {
        System.out.println("Library catalog:");
        for (Book b : library.getCatalog()) {
            System.out.println("  " + b);
        }
    }

    public void listBorrowRecords() {
        System.out.println("Borrow records:");
        for (BorrowRecord r : library.getBorrowRecords()) {
            System.out.println("  " + r);
        }
    }
}
