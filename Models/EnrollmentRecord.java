package Models;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentRecord {
    private List<String> courses = new ArrayList<>(); // store course codes

    public void addCourse(String courseCode) {
        if (!courses.contains(courseCode)) courses.add(courseCode);
    }

    public void removeCourse(String courseCode) {
        courses.remove(courseCode);
    }

    public List<String> getCourses() {
        return new ArrayList<>(courses);
    }

    public void printSchedule() {
        System.out.println("Enrolled courses:");
        if (courses.isEmpty()) {
            System.out.println("  (none)");
            return;
        }
        for (String c : courses) System.out.println("  " + c);
    }
}
