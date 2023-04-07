package hotelmanegementsystem;

import java.util.Date;
import java.util.Objects;

public class ReservationRoom {

    private Customer customer;
    private Room room;
    Date startDate;
    Date endDate;

    //Constructors
    public ReservationRoom() {

        this.customer = new Customer();
        this.room = new Room() {
            
            @Override
            public float GetFinalCost() {
                return getCostForOneDay();
            }
        };
        this.room.MakeABooking();

        startDate = new Date();
        endDate = new Date();

    }

    public ReservationRoom(Customer customer, Room room, Date startDate, Date endDate) {
        this.customer = customer;
        this.room = room;
        this.room.MakeABooking();
        this.startDate = startDate;
        this.endDate = endDate;
    }

    //Getters
    public Customer getCustomer() {
        return customer;
    }

    public Booking getRoom() {
        return room;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    //Setters 
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
        final ReservationRoom other = (ReservationRoom) obj;
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (!Objects.equals(this.room, other.room)) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.endDate, other.endDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ReservationRoom{" + "\ncustomer=" + customer + ", \nroom=" + room + ", \nstartDate=" + startDate + ", \nendDate=" + endDate + '}';
    }

}
