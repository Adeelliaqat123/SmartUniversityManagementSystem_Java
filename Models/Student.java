package Models;

import interfaces.Enrollable;
import interfaces.Payable;

public class Student extends Person implements Enrollable, Payable {
    private String program;
    private Transcript transcript;
    private EnrollmentRecord record;
    private double balanceDue;

    public Student(String id, String name, String email, String phone, String program) {
        super(id, name, email, phone);
        this.program = program;
        this.transcript = new Transcript();
        this.record = new EnrollmentRecord();
        this.balanceDue = 0.0;
    }

    public Transcript getTranscript() { return transcript; }
    public EnrollmentRecord getEnrollmentRecord() { return record; }
    public String getProgram() { return program; }

    // Enrollable
    @Override
    public void enrollInCourse(String courseCode) {
        record.addCourse(courseCode);
        System.out.println(getName() + " enrolled in " + courseCode);
    }

    @Override
    public void dropCourse(String courseCode) {
        record.removeCourse(courseCode);
        System.out.println(getName() + " dropped " + courseCode);
    }

    @Override
    public void viewSchedule() {
        System.out.println(getName() + "'s schedule:");
        record.printSchedule();
    }

    // Payable
    @Override
    public void processPayment(double amount) {
        balanceDue = Math.max(0.0, balanceDue - amount);
        System.out.println(getName() + " paid " + amount + ". Remaining due: " + balanceDue);
    }

    @Override
    public String generateInvoice() {
        return "Invoice for " + getName() + ": due " + balanceDue;
    }

    @Override
    public String getFinancialSummary() {
        return "Balance due: " + balanceDue;
    }

    // student-specific
    public void addGrade(String courseCode, String grade) {
        transcript.addGrade(courseCode, grade);
    }

    public double calculateGPA() {
        return transcript.calculateGPA();
    }

    public void printTranscript() {
        System.out.println(getName() + "'s Transcript:");
        transcript.printTranscript();
    }

    public void setBalanceDue(double amount) { this.balanceDue = amount; }

    @Override
    public void register() {
        System.out.println("Student " + getName() + " registered for " + program);
    }

    @Override
    public void login() {
        System.out.println("Student " + getName() + " logged in.");
    }

    @Override
    public String getRole() {
        return "Student";
    }
}
