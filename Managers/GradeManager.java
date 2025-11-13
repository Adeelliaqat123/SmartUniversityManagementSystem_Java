package Managers;

import Models.Student;
import Models.Course;

public class GradeManager {
    private PersonManager personManager;
    private CourseManager courseManager;

    public GradeManager(PersonManager pm, CourseManager cm) {
        this.personManager = pm;
        this.courseManager = cm;
    }

    public void assignGrade(String studentId, String courseCode, String grade) {
        Student s = personManager.findStudentById(studentId);
        Course c = courseManager.findCourseByCode(courseCode);
        if (s == null || c == null) {
            System.out.println("Student or Course not found");
            return;
        }
        s.addGrade(courseCode, grade);
        System.out.println("Assigned grade " + grade + " to student " + studentId + " for " + courseCode);
    }

    public void printGPA(String studentId) {
        Student s = personManager.findStudentById(studentId);
        if (s == null) {
            System.out.println("Student not found");
            return;
        }
        System.out.println("GPA for " + s.getName() + " is " + s.calculateGPA());
    }
}
