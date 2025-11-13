package Models;

import interfaces.Researchable;

public class PhDStudent extends Student implements Researchable {
    private String researchArea;

    public PhDStudent(String id, String name, String email, String phone, String program, String researchArea) {
        super(id, name, email, phone, program);
        this.researchArea = researchArea;
    }

    public String getResearchArea() { return researchArea; }

    @Override
    public void publishPaper(String title) {
        System.out.println(getName() + " published paper: " + title);
    }

    @Override
    public void conductResearch(String topic) {
        System.out.println(getName() + " is researching: " + topic);
    }

    @Override
    public void applyForGrant(String grantName) {
        System.out.println(getName() + " applied for grant: " + grantName);
    }

    @Override
    public void register() {
        System.out.println("PhD Student " + getName() + " registered in research area: " + researchArea);
    }

    @Override
    public String getRole() {
        return "PhD Student";
    }
}
