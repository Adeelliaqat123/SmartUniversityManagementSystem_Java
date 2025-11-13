package Models;

import java.util.ArrayList;
import java.util.List;


public class Department {
    private String code;           
    private String name;
    private List<Faculty> faculties;      
    private List<Course> courseOfferings; 
    private Budget budget;                

    public Department(String code, String name, double initialBudget) {
        this.code = code;
        this.name = name;
        this.faculties = new ArrayList<>();
        this.courseOfferings = new ArrayList<>();
        this.budget = new Budget(initialBudget);
    }

    // Basic info
    public String getCode() { return code; }
    public String getName() { return name; }

    // Faculty management (aggregation)
    public boolean addFaculty(Faculty f) {
        if (f == null) return false;
        if (!faculties.contains(f)) {
            faculties.add(f);
            return true;
        }
        return false;
    }

    public boolean removeFaculty(Faculty f) {
        return faculties.remove(f);
    }

    public List<Faculty> getFaculties() {
        return new ArrayList<>(faculties);
    }

    // Course offerings
    public boolean addCourseOffering(Course c) {
        if (c == null) return false;
        if (!courseOfferings.contains(c)) {
            courseOfferings.add(c);
            return true;
        }
        return false;
    }

    public boolean removeCourseOffering(Course c) {
        return courseOfferings.remove(c);
    }

    public List<Course> getCourseOfferings() {
        return new ArrayList<>(courseOfferings);
    }

    // Budget composition
    public Budget getBudget() { return budget; }

    @Override
    public String toString() {
        return String.format("Department[%s - %s] faculties=%d courses=%d %s", code, name, faculties.size(), courseOfferings.size(), budget);
    }
}
