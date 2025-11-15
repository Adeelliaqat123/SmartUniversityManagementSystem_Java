package Main;

import java.time.LocalDateTime;

import Managers.*;
import Models.*;

public class main {
    public static void main(String[] args) {

        // MODULE 1 & 2 TESTING
        PersonManager pm = new PersonManager();
        CourseManager cm = new CourseManager();
        EnrollmentManager em = new EnrollmentManager(cm, pm);
        GradeManager gm = new GradeManager(pm, cm);

        // Create people
        UndergraduateStudent u1 = new UndergraduateStudent("S1001", "Ali Khan", "ali@uni.edu", "0300-1111111", "BSCS",
                2);
        GraduateStudent g1 = new GraduateStudent("S1002", "Sara Ali", "sara@uni.edu", "0300-2222222", "MSCS", "F101");
        PhDStudent p1 = new PhDStudent("S1003", "Zain Malik", "zain@uni.edu", "0300-3333333", "PhD-CS",
                "Machine Learning");

        Professor prof = new Professor("F500", "Dr. Ahmed", "ahmed@uni.edu", "0333-4444444", "CS", 150000);
        Lecturer lec = new Lecturer("F501", "Ms. Naila", "naila@uni.edu", "0333-5555555", "SE", 80000);
        Administrator admin = new Administrator("ST01", "Mr. Khan", "khan@uni.edu", "0344-6667777", "Registrar", 60000);
        Librarian lib = new Librarian("ST02", "Mrs. Fatima", "fatima@uni.edu", "0345-8889990", "Library", 50000);

        // Add people
        pm.addPerson(u1);
        pm.addPerson(g1);
        pm.addPerson(p1);
        pm.addPerson(prof);
        pm.addPerson(lec);
        pm.addPerson(admin);
        pm.addPerson(lib);

        // Create courses
        Course c1 = cm.createCourse("CS101", "Intro to Programming", 3, 40);
        Course c2 = cm.createCourse("CS201", "Data Structures", 3, 30);

        cm.listCourses();

        // Enroll
        em.enrollStudent("S1001", "CS101");
        em.enrollStudent("S1002", "CS101");
        em.enrollStudent("S1003", "CS201");

        // Grades
        gm.assignGrade("S1001", "CS101", "A");
        gm.assignGrade("S1002", "CS101", "B");
        gm.assignGrade("S1003", "CS201", "A");

        u1.printTranscript();
        System.out.println("GPA: " + u1.calculateGPA());
        gm.printGPA("S1002");

        pm.printAll();

        // MODULE 3: Department System
        System.out.println("\n=== MODULE 3: Department System ===");

        DepartmentManager dm = new DepartmentManager();

        Department csDept = dm.createDepartment("CS", "Computer Science", 500000);
        Department seDept = dm.createDepartment("SE", "Software Engineering", 300000);

        dm.assignFacultyToDepartment(csDept, prof);
        dm.assignFacultyToDepartment(seDept, lec);

        dm.addCourseToDepartment(csDept, c1);
        dm.addCourseToDepartment(seDept, c2);

        dm.allocateBudget(csDept, 100000);
        dm.allocateBudget(seDept, 250000);

        dm.printAllDepartments();

        // MODULE 4: Library System
        System.out.println("\n=== MODULE 4: Library System ===");

        Library library = new Library("TechVerse Central Library");
        LibraryManager lm = new LibraryManager(library);

        Book b1 = new Book("B001", "Clean Code", "Robert Martin", 5);
        Book b2 = new Book("B002", "Artificial Intelligence", "Stuart Russell", 3);
        Book b3 = new Book("B003", "Data Structures in Java", "Goodrich", 2);

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        lm.listAvailableBooks();

        lm.borrowBook(u1.getId(), u1.getRole(), b1.getIsbn());
        lm.borrowBook(prof.getId(), prof.getRole(), b2.getIsbn());
        lm.borrowBook(g1.getId(), g1.getRole(), b3.getIsbn());

        lm.listBorrowRecords();

        lm.returnBook(u1.getId(), b1.getIsbn());

        System.out.println("Current fines for " + u1.getName() + ": " + lm.calculateFine(u1.getId()));

        lm.listAvailableBooks();
        lm.listBorrowRecords();

        // MODULE 5: FINANCIAL SYSTEM

        System.out.println("\n=== MODULE 5: Financial System ===");

        FinancialManager fm = new FinancialManager(pm, cm);

        fm.setPerCreditRate("BSCS", 300.0); // set tuition rate

        // Generate invoice
        Invoice inv = fm.generateInvoiceForStudent(u1);

        // Process tuition payment
        fm.processPayment(u1.getId(), inv.getAmount(), "Tuition Payment");

        // Award scholarship
        Scholarship sch = new Scholarship("SCH-01", Scholarship.Type.MERIT, 500.0, u1.getId());
        fm.awardScholarship(sch);

        // Faculty salary
        fm.processSalaryPayment(prof, 200000);

        // Print summary
        fm.printFinancialSummaryForStudent("S1001");

        // MODULE 6: FACILITY MANAGEMENT

        System.out.println("\n=== MODULE 6: Facility Management ===");

        FacilityManager fac = new FacilityManager();

        fac.addClassroom(new Classroom("R101", 60, "Main Building - Floor 1"));
        fac.addLab(new Lab("L201", 30, "VR & AI Lab"));
        fac.addOffice(new Office("O301", "Admin Block", 12));

        // Office assignment
        fac.assignOfficeToFaculty(prof.getId(), "O301");

        // Lab assignment
        fac.assignLabToCourse("CS101", "L201");

        // Allocate classroom
        LocalDateTime s1 = LocalDateTime.of(2025, 11, 20, 9, 0);
        LocalDateTime e1 = LocalDateTime.of(2025, 11, 20, 10, 30);

        fac.allocateClassroom("R101", "CS101", s1, e1);

        fac.printAllocations();
        fac.listClassrooms();
        fac.listLabs();
        fac.listOffices();

    }
}
