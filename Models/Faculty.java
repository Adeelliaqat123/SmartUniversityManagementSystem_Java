package Models;

import interfaces.Teachable;
import interfaces.Payable;
import interfaces.Researchable;

public class Faculty extends Person implements Teachable, Payable, Researchable {
    private String department;
    private double salary;

    public Faculty(String id, String name, String email, String phone, String department, double salary) {
        super(id, name, email, phone);
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public void teachCourse(String courseCode) {
        System.out.println(getName() + " will teach " + courseCode);
    }

    @Override
    public void assignGrade(String studentId, String courseCode, String grade) {
        System.out.println(getName() + " assigned grade " + grade + " to student " + studentId + " for " + courseCode);
    }

    @Override
    public void holdOfficeHours() {
        System.out.println(getName() + " is holding office hours.");
    }

    @Override
    public void processPayment(double amount) {
        salary += amount;
        System.out.println(getName() + " received salary payment: " + amount);
    }

    @Override
    public String generateInvoice() {
        return "Salary invoice for " + getName();
    }

    @Override
    public String getFinancialSummary() {
        return "Salary: " + salary;
    }

    @Override
    public void publishPaper(String title) {
        System.out.println(getName() + " published: " + title);
    }

    @Override
    public void conductResearch(String topic) {
        System.out.println(getName() + " researching: " + topic);
    }

    @Override
    public void applyForGrant(String grantName) {
        System.out.println(getName() + " applied for grant: " + grantName);
    }

    @Override
    public void register() {
        System.out.println("Faculty " + getName() + " registered in " + department);
    }

    @Override
    public void login() {
        System.out.println("Faculty " + getName() + " logged in.");
    }

    @Override
    public String getRole() {
        return "Faculty";
    }
}
