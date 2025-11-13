package Models;

public class Librarian extends Staff {
    public Librarian(String id, String name, String email, String phone, String position, double salary) {
        super(id, name, email, phone, position, salary);
    }

    public void issueBook(String title) {
        System.out.println(getName() + " issued book: " + title);
    }

    @Override
    public String getRole() {
        return "Librarian";
    }
}
