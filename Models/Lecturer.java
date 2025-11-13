package Models;

public class Lecturer extends Faculty {
    public Lecturer(String id, String name, String email, String phone, String department, double salary) {
        super(id, name, email, phone, department, salary);
    }

    @Override
    public String getRole() {
        return "Lecturer";
    }
}
