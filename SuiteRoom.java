package hotelmanegementsystem;

public class SuiteRoom extends Room {

    public SuiteRoom(String roomID, int roomFloor, int capacity, boolean isBooked, float costForOneDay) {
        super(roomID, roomFloor, capacity, isBooked, costForOneDay);
    }

    public SuiteRoom() {
    }

    
    
    @Override
    public float GetFinalCost() {
        return getCostForOneDay() * 2;
    }

}
