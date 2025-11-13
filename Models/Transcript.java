package Models;

import java.util.LinkedHashMap;
import java.util.Map;

public class Transcript {
    private Map<String, String> grades = new LinkedHashMap<>(); // courseCode -> grade

    public void addGrade(String courseCode, String grade) {
        grades.put(courseCode, grade);
    }

    public Map<String, String> getGrades() {
        return new LinkedHashMap<>(grades);
    }

    public double calculateGPA() {
        if (grades.isEmpty()) return 0.0;
        double total = 0;
        int count = 0;
        for (String g : grades.values()) {
            switch (g.toUpperCase()) {
                case "A": total += 4.0; break;
                case "B": total += 3.0; break;
                case "C": total += 2.0; break;
                case "D": total += 1.0; break;
                default: total += 0.0; break;
            }
            count++;
        }
        return count == 0 ? 0.0 : total / count;
    }

    public void printTranscript() {
        System.out.println("Transcript:");
        if (grades.isEmpty()) {
            System.out.println("  (no grades)");
            return;
        }
        grades.forEach((c, g) -> System.out.println("  " + c + " -> " + g));
    }
}
