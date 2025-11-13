package Managers;

import java.util.ArrayList;
import java.util.List;
import Models.*;

public class PersonManager {
    private List<Person> people = new ArrayList<>();

    public void addPerson(Person p) {
        people.add(p);
        p.register();
    }

    public Student findStudentById(String id) {
        for (Person p : people) {
            if (p instanceof Student && p.getId().equals(id)) return (Student) p;
        }
        return null;
    }

    public Faculty findFacultyById(String id) {
        for (Person p : people) {
            if (p instanceof Faculty && p.getId().equals(id)) return (Faculty) p;
        }
        return null;
    }

    public void printAll() {
        System.out.println("---- People ----");
        for (Person p : people) {
            System.out.println(p.getRole() + " | " + p.getId() + " | " + p.getName());
        }
    }
}
