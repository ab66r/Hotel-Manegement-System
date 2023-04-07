package hotelmanegementsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Hotel {

    private String name;
    private ArrayList<Room> rooms;
    private ArrayList<ReservationRoom> reservations;

    //Constructor
    public Hotel() {
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.name = "";
    }

    public Hotel(String name, ArrayList<Room> rooms, ArrayList<ReservationRoom> reservations) {
        this.name = name;
        this.rooms = rooms;
        this.reservations = reservations;
    }

    //Setters
    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public void setReservations(ArrayList<ReservationRoom> reservations) {
        this.reservations = reservations;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Getters
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<ReservationRoom> getReservations() {
        return reservations;
    }

    public String getName() {
        return name;
    }

    //to string method
    @Override
    public String toString() {
        return "Hotel{" + "\nrooms=\n\t" + rooms + ", reservations=\n\t" + reservations + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hotel other = (Hotel) obj;
        if (!Objects.equals(this.rooms, other.rooms)) {
            return false;
        }
        if (!Objects.equals(this.reservations, other.reservations)) {
            return false;
        }
        return true;
    }

    //operations
    public void AddARoom(Room room) {
        rooms.add(room);
    }

    public void RemoveARoom(Room room) {
        getRooms().remove(room);
    }

    public void AddAReservation(ReservationRoom reservationRoom) {
        getReservations().add(reservationRoom);
    }

    public void AddAReservation(Customer customer, Room room, Date startDate, Date endDate) {

        getReservations().add(new ReservationRoom(customer, room, startDate, endDate));
    }

    public String ShowAvailableRooms() {
        String out = "";
        for (Room room : rooms) {
            if (!room.isBooked()) {
                out += room.getClass().getSimpleName() + ": " + room + "\n";
            }
        }
        return out;
    }

    public ArrayList<Room> GetTypeRoomsAvailable(String type) {
        ArrayList<Room> viprs = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getClass().getSimpleName().equals(type + "Room") && !room.isBooked()) {
                viprs.add(room);
            }
        }
        return viprs;
    }

    public Room GetAvailableRoomByID(String id, String type) {
        for (Room room : GetTypeRoomsAvailable(type)) {
            if (room.getRoomID().equals(id)) {
                return room;
            }
        }

        return null;
    }

    public ArrayList<ReservationRoom> GetReservationByNameOfCustomer(String firstName, String lastName) {
        ArrayList<ReservationRoom> reservationRoomsOfUser = new ArrayList<>();
        for (ReservationRoom reservationRoom : reservations) {
            if (reservationRoom.getCustomer().getFirstName().equals(firstName) && reservationRoom.getCustomer().getLastName().equals(lastName)) {
                reservationRoomsOfUser.add(reservationRoom);
            }
        }
        return reservationRoomsOfUser;
    }
    
    public Room GetRoomByID(String id) {
        for (Room room : getRooms()) {
            if (room.getRoomID().equals(id)) {
                return room;
            }
        }

        return null;
    }
    

}
