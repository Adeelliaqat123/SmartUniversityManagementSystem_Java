package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Library aggregates Book objects. Books exist independently of library,
 * but Library holds and manages the collection and borrow records.
 */
public class Library {
    private String name;
    private List<Book> catalog;
    private List<BorrowRecord> borrowRecords;

    public Library(String name) {
        this.name = name;
        this.catalog = new ArrayList<>();
        this.borrowRecords = new ArrayList<>();
    }

    public String getName() { return name; }

    public void addBook(Book b) {
        if (b != null) catalog.add(b);
    }

    public Book findByISBN(String isbn) {
        for (Book b : catalog) if (b.getIsbn().equals(isbn)) return b;
        return null;
    }

    public List<Book> getCatalog() {
        return new ArrayList<>(catalog);
    }

    public void addBorrowRecord(BorrowRecord r) {
        borrowRecords.add(r);
    }

    public BorrowRecord findActiveRecord(String borrowerId, String isbn) {
        for (BorrowRecord r : borrowRecords) {
            if (r.getBorrowerId().equals(borrowerId) && r.getIsbn().equals(isbn) && r.getReturnDate() == null) {
                return r;
            }
        }
        return null;
    }

    public List<BorrowRecord> getBorrowRecords() {
        return new ArrayList<>(borrowRecords);
    }
}
