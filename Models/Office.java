package Models;


public class Office {
    private String officeId;
    private String building;
    private int roomNumber;

    public Office(String officeId, String building, int roomNumber) {
        this.officeId = officeId;
        this.building = building;
        this.roomNumber = roomNumber;
    }

    public String getOfficeId() { return officeId; }
    public String getBuilding() { return building; }
    public int getRoomNumber() { return roomNumber; }

    @Override
    public String toString() {
        return "Office[" + officeId + "] " + building + "-" + roomNumber;
    }
}
