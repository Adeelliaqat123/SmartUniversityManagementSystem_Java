package interfaces;

public interface Enrollable {
    void enrollInCourse(String courseCode);
    void dropCourse(String courseCode);
    void viewSchedule();
}
