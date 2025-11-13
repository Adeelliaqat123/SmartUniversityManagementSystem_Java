package Managers;

import Models.Course;
import Models.Student;

public class EnrollmentManager {
    private CourseManager courseManager;
    private PersonManager personManager;

    public EnrollmentManager(CourseManager cm, PersonManager pm) {
        this.courseManager = cm;
        this.personManager = pm;
    }

    public boolean enrollStudent(String studentId, String courseCode) {
        Student s = personManager.findStudentById(studentId);
        Course c = courseManager.findCourseByCode(courseCode);
        if (s == null || c == null) {
            System.out.println("Student or course not found.");
            return false;
        }
        // simple prerequisite check omitted; capacity check done by Course
        if (c.addStudent(studentId)) {
            s.enrollInCourse(courseCode);
            System.out.println("Enrolled student " + studentId + " in " + courseCode);
            return true;
        } else {
            System.out.println("Course full or already enrolled.");
            return false;
        }
    }

    public void dropStudent(String studentId, String courseCode) {
        Student s = personManager.findStudentById(studentId);
        Course c = courseManager.findCourseByCode(courseCode);
        if (s == null || c == null) {
            System.out.println("Student or course not found.");
            return;
        }
        c.removeStudent(studentId);
        s.dropCourse(courseCode);
        System.out.println("Dropped student " + studentId + " from " + courseCode);
    }
}
