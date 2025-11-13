package Managers;

import java.util.ArrayList;
import java.util.List;
import Models.*;

public class CourseManager {
    private List<Course> courses = new ArrayList<>();

    public Course createCourse(String code, String title, int credits, int capacity) {
        Course c = new Course(code, title, credits, capacity);
        courses.add(c);
        return c;
    }

    public Course findCourseByCode(String code) {
        for (Course c : courses) if (c.getCode().equals(code)) return c;
        return null;
    }

    public void listCourses() {
        System.out.println("Courses:");
        for (Course c : courses) {
            System.out.println("  " + c.getCode() + " - " + c.getTitle());
        }
    }
}
