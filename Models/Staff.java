package Models;

import interfaces.Payable;

public class Staff extends Person implements Payable {
    private String position;
    private double salary;

    public Staff(String id, String name, String email, String phone, String position, double salary) {
        super(id, name, email, phone);
        this.position = position;
        this.salary = salary;
    }

    public String getPosition() { return position; }

    @Override
    public void processPayment(double amount) {
        salary += amount;
        System.out.println(getName() + " staff salary increased by " + amount);
    }

    @Override
    public String generateInvoice() {
        return "Staff payslip for " + getName();
    }

    @Override
    public String getFinancialSummary() {
        return "Staff salary: " + salary;
    }

    @Override
    public void register() {
        System.out.println("Staff " + getName() + " registered as " + position);
    }

    @Override
    public void login() {
        System.out.println("Staff " + getName() + " logged in.");
    }

    @Override
    public String getRole() {
        return "Staff";
    }
}
