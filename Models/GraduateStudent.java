package Models;

public class GraduateStudent extends Student {
    private String advisorId;

    public GraduateStudent(String id, String name, String email, String phone, String program, String advisorId) {
        super(id, name, email, phone, program);
        this.advisorId = advisorId;
    }

    public String getAdvisorId() { return advisorId; }

    @Override
    public void register() {
        System.out.println("Graduate student " + getName() + " registered under advisor " + advisorId);
    }

    @Override
    public String getRole() {
        return "Graduate Student";
    }
}
