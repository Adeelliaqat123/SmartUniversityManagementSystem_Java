package Models;

import java.time.LocalDateTime;


public class FacilityAllocation {
    private String allocationId;
    private String resourceId; 
    private String courseCode;
    private LocalDateTime start;
    private LocalDateTime end;

    public FacilityAllocation(String allocationId, String resourceId, String courseCode, LocalDateTime start, LocalDateTime end) {
        this.allocationId = allocationId;
        this.resourceId = resourceId;
        this.courseCode = courseCode;
        this.start = start;
        this.end = end;
    }

    public String getAllocationId() { return allocationId; }
    public String getResourceId() { return resourceId; }
    public String getCourseCode() { return courseCode; }
    public LocalDateTime getStart() { return start; }
    public LocalDateTime getEnd() { return end; }

    public boolean conflictsWith(FacilityAllocation other) {
        if (!resourceId.equals(other.resourceId)) return false;
        return !(end.isBefore(other.start) || start.isAfter(other.end));
    }

    @Override
    public String toString() {
        return "Alloc[" + allocationId + "] resource=" + resourceId + " course=" + courseCode + " " + start + " - " + end;
    }
}
