package Models;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int copies; // available copies

    public Book(String isbn, String title, String author, int copies) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.copies = Math.max(0, copies);
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public int getCopies() { return copies; }

    public boolean borrowCopy() {
        if (copies <= 0) return false;
        copies--;
        return true;
    }

    public void returnCopy() {
        copies++;
    }

    @Override
    public String toString() {
        return String.format("Book[%s] %s by %s (copies=%d)", isbn, title, author, copies);
    }
}
