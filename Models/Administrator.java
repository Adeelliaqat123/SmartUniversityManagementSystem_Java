package Models;

public class Administrator extends Staff {
    public Administrator(String id, String name, String email, String phone, String position, double salary) {
        super(id, name, email, phone, position, salary);
    }

    public void manageRecords() {
        System.out.println(getName() + " is managing university records.");
    }

    @Override
    public String getRole() {
        return "Administrator";
    }
}
