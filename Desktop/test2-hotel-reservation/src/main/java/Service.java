package main.java;

import java.util.ArrayList;
import java.util.Date;

public class Service {

    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();

    // CREATE OR UPDATE ROOM
    
    public void setRoom(int roomNumber, RoomType roomType, int pricePerNight) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) {
                r.setRoomType(roomType);
                r.setPricePerNight(pricePerNight);
                return;
            }
        }
        rooms.add(new Room(roomNumber, roomType, pricePerNight));
    }

    // CREATE OR UPDATE USER

    public void setUser(int userId, int balance) {
        for (User u : users) {
            if (u.getUserId() == userId) {
                u.setBalance(balance);
                return;
            }
        }
        users.add(new User(userId, balance));
    }

    // BOOK ROOM

    public void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) {

        if (checkIn.after(checkOut)) {
            System.out.println("Invalid dates: checkIn is after checkOut.");
            return;
        }

        Room room = null;
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) {
                room = r;
                break;
            }
        }
        if (room == null) {
            System.out.println("Room does not exist.");
            return;
        }

        User user = null;
        for (User u : users) {
            if (u.getUserId() == userId) {
                user = u;
                break;
            }
        }
        if (user == null) {
            System.out.println("User does not exist.");
            return;
        }

        for (Booking b : bookings) {
            boolean overlap =
                    roomNumber == b.getRoomNumber() &&
                    checkIn.before(b.getCheckOut()) &&
                    checkOut.after(b.getCheckIn());

            if (overlap) {
                System.out.println("Room is already booked.");
                return;
            }
        }

        long diff = checkOut.getTime() - checkIn.getTime();
        int nights = (int) (diff / (1000 * 60 * 60 * 24));

        int totalCost = nights * room.getPricePerNight();
        if (user.getBalance() < totalCost) {
            System.out.println("Not enough balance.");
            return;
        }

        user.setBalance(user.getBalance() - totalCost);

        bookings.add(new Booking(
                userId,
                roomNumber,
                room.getRoomType(),
                room.getPricePerNight(),
                checkIn,
                checkOut
        ));

        System.out.println("Booking successful.");
    }


    // PRINT ALL ROOMS + BOOKINGS

    public void printAll() {

        System.out.println("\n--- Rooms (latest first) ---");
        for (int i = rooms.size() - 1; i >= 0; i--) {
            System.out.println(rooms.get(i));
        }

        System.out.println("\n--- Bookings (latest first) ---");
        for (int i = bookings.size() - 1; i >= 0; i--) {
            System.out.println(bookings.get(i));
        }
    }

    // PRINT ALL USERS
 
    public void printAllUsers() {
        System.out.println("\n--- Users (latest first) ---");
        for (int i = users.size() - 1; i >= 0; i--) {
            System.out.println(users.get(i));
        }
    }
}
