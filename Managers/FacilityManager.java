package Managers;

import java.time.LocalDateTime;
import java.util.*;

import Models.*;


public class FacilityManager {
    private Map<String, Classroom> classrooms = new HashMap<>();
    private Map<String, Lab> labs = new HashMap<>();
    private Map<String, Office> offices = new HashMap<>();

    private Map<String, String> facultyOfficeMap = new HashMap<>(); // facultyId -> officeId
    private Map<String, String> courseLabMap = new HashMap<>();    // courseCode -> labId

    private List<FacilityAllocation> allocations = new ArrayList<>();

    // Add resources
    public void addClassroom(Classroom c) { classrooms.put(c.getRoomId(), c); }
    public void addLab(Lab l) { labs.put(l.getLabId(), l); }
    public void addOffice(Office o) { offices.put(o.getOfficeId(), o); }

    public Classroom getClassroom(String id) { return classrooms.get(id); }
    public Lab getLab(String id) { return labs.get(id); }
    public Office getOffice(String id) { return offices.get(id); }

    // Assign office to faculty (one office per faculty check)
    public boolean assignOfficeToFaculty(String facultyId, String officeId) {
        if (!offices.containsKey(officeId)) return false;
        // ensure office not already assigned
        if (facultyOfficeMap.containsValue(officeId)) return false;
        facultyOfficeMap.put(facultyId, officeId);
        System.out.println("Assigned office " + officeId + " to faculty " + facultyId);
        return true;
    }

    public String getOfficeOfFaculty(String facultyId) {
        return facultyOfficeMap.get(facultyId);
    }

    // Assign lab to a course (aggregation)
    public boolean assignLabToCourse(String courseCode, String labId) {
        if (!labs.containsKey(labId)) return false;
        courseLabMap.put(courseCode, labId);
        System.out.println("Assigned lab " + labId + " to course " + courseCode);
        return true;
    }

    public String getLabOfCourse(String courseCode) {
        return courseLabMap.get(courseCode);
    }

    // Allocate classroom (check conflicts)
    public boolean allocateClassroom(String roomId, String courseCode, LocalDateTime start, LocalDateTime end) {
        if (!classrooms.containsKey(roomId)) return false;
        FacilityAllocation newAlloc = new FacilityAllocation(UUID.randomUUID().toString(), roomId, courseCode, start, end);
        for (FacilityAllocation a : allocations) {
            if (a.conflictsWith(newAlloc)) {
                System.out.println("Conflict detected with allocation: " + a);
                return false;
            }
        }
        allocations.add(newAlloc);
        System.out.println("Allocated classroom " + roomId + " to course " + courseCode + " (" + start + " -> " + end + ")");
        return true;
    }

    // Deallocate
    public boolean deallocate(String allocationId) {
        return allocations.removeIf(a -> a.getAllocationId().equals(allocationId));
    }

    // List allocations
    public void printAllocations() {
        System.out.println("Facility Allocations:");
        if (allocations.isEmpty()) System.out.println("  (none)");
        for (FacilityAllocation a : allocations) System.out.println("  " + a);
    }

    // Basic resource lists
    public void listClassrooms() {
        System.out.println("Classrooms:");
        for (Classroom c : classrooms.values()) System.out.println("  " + c);
    }

    public void listLabs() {
        System.out.println("Labs:");
        for (Lab l : labs.values()) System.out.println("  " + l);
    }

    public void listOffices() {
        System.out.println("Offices:");
        for (Office o : offices.values()) System.out.println("  " + o);
    }
}
