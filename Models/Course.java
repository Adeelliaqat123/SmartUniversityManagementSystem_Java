package Models;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String code;
    private String title;
    private int creditHours;
    private int capacity;
    private List<String> enrolledStudentIds = new ArrayList<>();
    private List<String> prerequisites = new ArrayList<>();

    public Course(String code, String title, int creditHours, int capacity) {
        this.code = code;
        this.title = title;
        this.creditHours = creditHours;
        this.capacity = capacity;
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public int getCreditHours() { return creditHours; }
    public int getCapacity() { return capacity; }

    public boolean addStudent(String studentId) {
        if (enrolledStudentIds.size() >= capacity) return false;
        if (!enrolledStudentIds.contains(studentId)) {
            enrolledStudentIds.add(studentId);
            return true;
        }
        return false;
    }

    public void removeStudent(String studentId) {
        enrolledStudentIds.remove(studentId);
    }

    public List<String> getEnrolledStudentIds() {
        return new ArrayList<>(enrolledStudentIds);
    }

    public void addPrerequisite(String courseCode) {
        if (!prerequisites.contains(courseCode)) prerequisites.add(courseCode);
    }

    public List<String> getPrerequisites() {
        return new ArrayList<>(prerequisites);
    }
}
