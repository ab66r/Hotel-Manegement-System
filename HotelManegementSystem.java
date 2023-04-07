package hotelmanegementsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class HotelManegementSystem {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcom to hotel management system");
        Hotel hotel = new Hotel();
        hotel.setName("Andalus Hotel");

        System.out.println("enter number of rooms to add it:");
        int numOFRooms = 0;
        try {
            numOFRooms = scanner.nextInt();
            if (numOFRooms <= 0) {
                throw new Exception();
            }
        } catch (Exception exception) {
            System.out.println("Error: enter a valid positive number");
            System.exit(0);
        }
        for (int i = 0; i < numOFRooms; i++) {
            System.out.println("#" + (i + 1));

            String type = ChooseingTypeOfRoom();

            System.out.println("enter room ID: ");
            String roomID = scanner.next();

            System.out.println("enter floor of room: ");
            int roomFloor = scanner.nextInt();

            System.out.println("enter capacity of room: ");
            int capacity = scanner.nextInt();

            System.out.println("enter cost of room for one day: ");
            float costForOneDay = scanner.nextInt();

            if (type.equals("VIP")) {
                hotel.AddARoom(new VIPRoom(roomID, roomFloor, capacity, false, costForOneDay));
            } else if (type.equals("Regular")) {
                hotel.AddARoom(new RegularRoom(roomID, roomFloor, capacity, false, costForOneDay));
            } else if (type.equals("Suite")) {
                hotel.AddARoom(new SuiteRoom(roomID, roomFloor, capacity, false, costForOneDay));
            }

        }

        int ans = 1;
        while (ans != 0) {
            System.out.println("0- Exit");
            System.out.println("1- Show available rooms: ");
            System.out.println("2- Make reservation");
            System.out.println("3- Show all reservations");
            System.out.println("4- Find reservation of customer");
            System.out.println("5- Cancel reservation of room");

            ans = scanner.nextInt();
            switch (ans) {
                case 0: {
                    System.out.println("Thank you ^_*");
                    System.exit(1);
                }
                case 1: {

                    ShowAvailableRooms(hotel);
                    break;
                }
                case 2: {

                    MakeReservation(hotel);
                    break;
                }
                case 3: {
                    System.out.println(hotel.getReservations());
                    break;
                }
                case 4: {
                    FindReservationOfCustomer(hotel);
                    break;
                }
                case 5: {
                    CancelReservatonOFRoom(hotel);
                    break;
                }
                default: {
                    System.out.println("Please choose a number from the menu");
                }
            }
        }
    }

    private static String ChooseingTypeOfRoom() {
        String type = "";
        do {
            System.out.println("choose type of room (VIP, Suite, Regular)");
            type = scanner.next();
        } while (!type.equals("VIP") && !type.equals("Suite") && !type.equals("Regular"));

        return type;
    }

    private static void ShowAvailableRooms(Hotel hotel) {
        String availble_rooms = hotel.ShowAvailableRooms();
        System.out.println(availble_rooms);

    }

    private static Room ChoosingRoomForReservation(Hotel hotel, String type) {
        ArrayList<Room> rooms = hotel.GetTypeRoomsAvailable(type);
        if (rooms.isEmpty()) {
            return null;
        }
        System.out.println(rooms);
        System.out.println("choose ID room");
        String id = scanner.next();
        Room room = hotel.GetAvailableRoomByID(id, type);
        return room;
    }

    private static Customer MakeCustomer() {
        System.out.println("enter your first name");
        String firstName = scanner.next();

        System.out.println("enter your last name");
        String lastName = scanner.next();

        System.out.println("enter your phone");
        String phone = scanner.next();

        System.out.println("enter your national number");
        long nationalNumber = scanner.nextLong();

        System.out.println("enter your nationality");
        String nationality = scanner.next();

        System.out.println("enter day of your birth");
        int day = scanner.nextInt();

        System.out.println("enter month of your birth");
        int month = scanner.nextInt();

        System.out.println("enter year of your birth");
        int year = scanner.nextInt();

        java.util.Date DOB = new Date(year - 1900, month, day);
        Customer customer = new Customer(firstName, lastName, phone, nationalNumber, nationality, DOB);

        return customer;
    }

    private static Date GetEndDate() {
        System.out.println("enter day of end reservation");
        int day = scanner.nextInt();

        System.out.println("enter month of end reservation");
        int month = scanner.nextInt();

        System.out.println("enter year of end reservation");
        int year = scanner.nextInt();
        Date endDate = new Date(year - 1900, month, day);
        return endDate;
    }

    private static void MakeReservation(Hotel hotel) {
        String type = ChooseingTypeOfRoom();

        Room room = ChoosingRoomForReservation(hotel, type);
        if (room == null) {
            System.out.println("\troom not found");
        } else {

            Customer customer = MakeCustomer();

            Date endDate = GetEndDate();

            hotel.AddAReservation(customer, room, new java.util.Date(), endDate);
        }
    }

    private static void FindReservationOfCustomer(Hotel hotel) {
        System.out.println("enter  name to lookup for reservation");
        System.out.println("enter first name");
        String firstName = scanner.next();
        System.out.println("enter last name");
        String lastName = scanner.next();

        ArrayList<ReservationRoom> reservationRoomsOfCustoer = hotel.GetReservationByNameOfCustomer(firstName, lastName);

        System.out.println(reservationRoomsOfCustoer);
    }

    private static void CancelReservatonOFRoom(Hotel hotel) {
        System.out.println("enter ID of room");
        String id = scanner.next();

        Room room = hotel.GetRoomByID(id);
        if (room == null) {
            System.out.println("ID of room is incorrect");
        }
        if (room.isBooked()) {
            room.CancelABooking();
            System.out.println("this room has been not booked");

        } else {
            System.out.println("this room is not booked");
        }

    }

}
