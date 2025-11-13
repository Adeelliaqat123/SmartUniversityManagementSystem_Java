package Models;

public class AssistantProfessor extends Faculty {
    public AssistantProfessor(String id, String name, String email, String phone, String department, double salary) {
        super(id, name, email, phone, department, salary);
    }

    @Override
    public String getRole() {
        return "Assistant Professor";
    }
}
