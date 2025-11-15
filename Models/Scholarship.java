package Models;

public class Scholarship {
    public enum Type { MERIT, NEED, RESEARCH }

    private String scholarshipId;
    private Type type;
    private double amount;
    private String studentId; 

    public Scholarship(String scholarshipId, Type type, double amount, String studentId) {
        this.scholarshipId = scholarshipId;
        this.type = type;
        this.amount = amount;
        this.studentId = studentId;
    }

    public String getScholarshipId() { return scholarshipId; }
    public Type getType() { return type; }
    public double getAmount() { return amount; }
    public String getStudentId() { return studentId; }

    @Override
    public String toString() {
        return "Scholarship[" + scholarshipId + "] " + type + " amount=" + amount + " student=" + studentId;
    }
}
