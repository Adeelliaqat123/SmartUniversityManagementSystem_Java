package interfaces;


public interface Teachable {
    void teachCourse(String courseCode);
    void assignGrade(String studentId, String courseCode, String grade);
    void holdOfficeHours();
}

