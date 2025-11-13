package Managers;

import java.util.ArrayList;
import java.util.List;
import Models.*;


public class DepartmentManager {
    private List<Department> departments = new ArrayList<>();

    public Department createDepartment(String code, String name, double initialBudget) {
        Department d = new Department(code, name, initialBudget);
        departments.add(d);
        System.out.println("Created department: " + d.getCode() + " - " + d.getName());
        return d;
    }

    public Department findByCode(String code) {
        for (Department d : departments) if (d.getCode().equalsIgnoreCase(code)) return d;
        return null;
    }

    public boolean assignFacultyToDepartment(Department d, Faculty f) {
        if (d == null || f == null) return false;
        boolean added = d.addFaculty(f);
        if (added) System.out.println("Assigned " + f.getName() + " to department " + d.getCode());
        return added;
    }

    public boolean addCourseToDepartment(Department d, Course c) {
        if (d == null || c == null) return false;
        boolean added = d.addCourseOffering(c);
        if (added) System.out.println("Added course " + c.getCode() + " to department " + d.getCode());
        return added;
    }

    public boolean allocateBudget(Department d, double amount) {
        if (d == null) return false;
        boolean ok = d.getBudget().allocate(amount);
        if (ok) System.out.println("Allocated " + amount + " from " + d.getCode() + " budget");
        else System.out.println("Allocation failed for " + d.getCode() + ". Remaining: " + d.getBudget().getRemaining());
        return ok;
    }

    public List<Department> listDepartments() {
        return new ArrayList<>(departments);
    }

    public void printAllDepartments() {
        System.out.println("=== Departments ===");
        for (Department d : departments) System.out.println(d);
    }
}
