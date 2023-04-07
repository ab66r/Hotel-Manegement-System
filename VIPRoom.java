package hotelmanegementsystem;

public class VIPRoom extends Room {

    public VIPRoom() {
    }

    public VIPRoom(String roomID, int roomFloor, int capacity, boolean isBooked, float costForOneDay) {
        super(roomID, roomFloor, capacity, isBooked, costForOneDay);
    }

    
    
    

    
    @Override
    public float GetFinalCost() {
        return getCostForOneDay() * 3;

    }
    
    

}
