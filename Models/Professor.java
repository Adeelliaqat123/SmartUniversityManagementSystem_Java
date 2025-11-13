package Models;

public class Professor extends Faculty {
    public Professor(String id, String name, String email, String phone, String department, double salary) {
        super(id, name, email, phone, department, salary);
    }

    @Override
    public String getRole() {
        return "Professor";
    }
}
