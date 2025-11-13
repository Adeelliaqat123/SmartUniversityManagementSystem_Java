package Models;

public class UndergraduateStudent extends Student {
    private int year;

    public UndergraduateStudent(String id, String name, String email, String phone, String program, int year) {
        super(id, name, email, phone, program);
        this.year = year;
    }

    public int getYear() { return year; }

    @Override
    public void register() {
        System.out.println("Undergraduate " + getName() + " registered (Year " + year + ")");
    }

    @Override
    public String getRole() {
        return "Undergraduate Student";
    }
}
