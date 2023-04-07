/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanegementsystem;

import java.util.Objects;

/**
 *
 * @author lilas
 */
public abstract class Room implements Booking {

    private String roomID;
    private int roomFloor;
    private int capacity;
    private boolean Booked;
    private float costForOneDay;

    //Constructor with parameter
    public Room(String roomID, int roomFloor, int capacity, boolean isBooked, float costForOneDay) {
        this.roomID = roomID;
        this.roomFloor = roomFloor;
        this.capacity = capacity;
        this.Booked = isBooked;
        this.costForOneDay = costForOneDay;
    }

    //Constructor without parameter
    public Room() {
        this.roomID = "";
        this.roomFloor = 0;
        this.capacity = 0;
        this.Booked = false;
        this.costForOneDay = 0;
    }

    //Getters
    public String getRoomID() {
        return roomID;
    }

    public int getRoomFloor() {
        return roomFloor;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isBooked() {
        return Booked;
    }

    public float getCostForOneDay() {
        return costForOneDay;
    }

    //Setters
    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public void setRoomFloor(int roomFloor) {
        this.roomFloor = roomFloor;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setIsBooked(boolean isBooked) {
        this.Booked = isBooked;
    }

    public void setCostForOneDay(float costForOneDay) {
        this.costForOneDay = costForOneDay;
    }

    //this is an abstract method which calculate final cost of room.
    public abstract float GetFinalCost();

    //tostring method
    @Override
    public String toString() {
        return "Room{" + "roomID=" + roomID + ", roomFloor=" + roomFloor + ", capacity=" + capacity + ", Booked=" + Booked + ", costForOneDay=" + GetFinalCost() + '}';
    }

    //equal method
    @Override
    public boolean equals(Object obj) {

        // first if this object is equal to itself then return true
        if (this == obj) {
            return true;
        }
        // if the object is null then return false
        if (obj == null) {
            return false;
        }
        // if the class of object is not equal to Room class then return false
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Room other = (Room) obj;

        // Compare between different attributes, if all are equal then return true ,
        // otherwise at least one is different then return false
        if (this.roomFloor != other.roomFloor) {
            return false;
        }
        if (this.capacity != other.capacity) {
            return false;
        }
        if (this.Booked != other.Booked) {
            return false;
        }
        if (Float.floatToIntBits(this.costForOneDay) != Float.floatToIntBits(other.costForOneDay)) {
            return false;
        }
        if (!Objects.equals(this.roomID, other.roomID)) {
            return false;
        }
        return true;
    }

    @Override
    public void CancelABooking() {
        setIsBooked(false);

    }

    @Override
    public void MakeABooking() {
        setIsBooked(true);
    }

}
