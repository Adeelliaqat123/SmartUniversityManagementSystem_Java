package Models;


public class Classroom {
    private String roomId;
    private int capacity;
    private String location; 

    public Classroom(String roomId, int capacity, String location) {
        this.roomId = roomId;
        this.capacity = capacity;
        this.location = location;
    }

    public String getRoomId() { return roomId; }
    public int getCapacity() { return capacity; }
    public String getLocation() { return location; }

    @Override
    public String toString() {
        return "Classroom[" + roomId + "] cap=" + capacity + " loc=" + location;
    }
}
