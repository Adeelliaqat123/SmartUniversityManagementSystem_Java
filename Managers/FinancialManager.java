package Managers;

import java.time.LocalDate;
import java.util.*;

import Models.*;


public class FinancialManager {
    private PersonManager personmanager;
    private CourseManager courseManager;
    private Map<String, Invoice> invoices = new HashMap<>();
    private List<Payment> payments = new ArrayList<>();
    private Map<String, List<Scholarship>> scholarshipsByStudent = new HashMap<>();

    
    private Map<String, Double> perCreditRateByProgram = new HashMap<>();

    public FinancialManager(PersonManager pm, CourseManager cm) {
        this.personmanager = pm;
        this.courseManager = cm;

        
        perCreditRateByProgram.put("BSCS", 250.0);
        perCreditRateByProgram.put("MSCS", 400.0);
        perCreditRateByProgram.put("PhD-CS", 200.0); 
        perCreditRateByProgram.put("DEFAULT", 300.0);
    }

    public void setPerCreditRate(String program, double rate) {
        perCreditRateByProgram.put(program, rate);
    }

    
    public double calculateTuition(Student s) {
        double rate = perCreditRateByProgram.getOrDefault(s.getProgram(), perCreditRateByProgram.get("DEFAULT"));
        int totalCredits = 0;
        for (String courseCode : s.getEnrollmentRecord().getCourses()) {
            Course c = courseManager.findCourseByCode(courseCode);
            if (c != null) totalCredits += c.getCreditHours();
        }
        return totalCredits * rate;
    }

    
    public Invoice generateInvoiceForStudent(Student s) {
        double amount = calculateTuition(s);
        
        List<Scholarship> list = scholarshipsByStudent.getOrDefault(s.getId(), Collections.emptyList());
        double scholarshipTotal = list.stream().mapToDouble(Scholarship::getAmount).sum();
        double net = Math.max(0.0, amount - scholarshipTotal);
        Invoice inv = new Invoice(s.getId(), net);
        invoices.put(inv.getInvoiceId(), inv);
        System.out.println("Generated invoice " + inv);
        return inv;
    }

    
    public Payment processPayment(String payerId, double amount, String description) {
        String pid = "PAY-" + UUID.randomUUID().toString().substring(0,8);
        Payment p = new Payment(pid, payerId, amount, LocalDate.now(), description);
        payments.add(p);
       
        if (description != null && description.toLowerCase().contains("tuition")) {
            
            for (Invoice inv : invoices.values()) {
                if (!inv.isPaid() && inv.getStudentId().equals(payerId)) {
                    if (amount >= inv.getAmount()) {
                        inv.markPaid();
                        System.out.println("Invoice " + inv.getInvoiceId() + " marked paid.");
                        break;
                    }
                }
            }
        }
        System.out.println("Processed payment: " + p);
        return p;
    }

    
    public void processSalaryPayment(Person p, double amount) {
        
        processPayment(p.getId(), amount, "Salary");
    }

   
    public void awardScholarship(Scholarship s) {
        scholarshipsByStudent.computeIfAbsent(s.getStudentId(), k -> new ArrayList<>()).add(s);
        System.out.println("Awarded scholarship: " + s);
    }

    public List<Payment> getPayments() { return new ArrayList<>(payments); }
    public List<Invoice> getAllInvoices() { return new ArrayList<>(invoices.values()); }
    public List<Scholarship> getScholarshipsForStudent(String studentId) {
        return new ArrayList<>(scholarshipsByStudent.getOrDefault(studentId, Collections.emptyList()));
    }

    
    public void printFinancialSummaryForStudent(String studentId) {
        System.out.println("=== Financial Summary for student " + studentId + " ===");
        for (Invoice inv : invoices.values()) {
            if (inv.getStudentId().equals(studentId)) System.out.println(inv);
        }
        for (Payment pay : payments) {
            if (pay.getPayerId().equals(studentId)) System.out.println(pay);
        }
        for (Scholarship sch : getScholarshipsForStudent(studentId)) System.out.println(sch);
    }
}
