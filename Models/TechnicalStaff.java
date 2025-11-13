package Models;

public class TechnicalStaff extends Staff {
    public TechnicalStaff(String id, String name, String email, String phone, String position, double salary) {
        super(id, name, email, phone, position, salary);
    }

    public void maintainSystems() {
        System.out.println(getName() + " is maintaining technical systems.");
    }

    @Override
    public String getRole() {
        return "Technical Staff";
    }
}
