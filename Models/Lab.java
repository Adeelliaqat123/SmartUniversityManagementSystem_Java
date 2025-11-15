package Models;


public class Lab {
    private String labId;
    private int capacity;
    private String equipmentNotes;

    public Lab(String labId, int capacity, String equipmentNotes) {
        this.labId = labId;
        this.capacity = capacity;
        this.equipmentNotes = equipmentNotes;
    }

    public String getLabId() { return labId; }
    public int getCapacity() { return capacity; }
    public String getEquipmentNotes() { return equipmentNotes; }

    @Override
    public String toString() {
        return "Lab[" + labId + "] cap=" + capacity + " notes=" + equipmentNotes;
    }
}
