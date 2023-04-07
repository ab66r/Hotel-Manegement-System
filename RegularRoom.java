package hotelmanegementsystem;

public class RegularRoom extends Room {

    public RegularRoom(String roomID, int roomFloor, int capacity, boolean isBooked, float costForOneDay) {
        super(roomID, roomFloor, capacity, isBooked, costForOneDay);
    }

    public RegularRoom() {
    }

    
    
    @Override
    public float GetFinalCost() {
        return getCostForOneDay();
    }

}
