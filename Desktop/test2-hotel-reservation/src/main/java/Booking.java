package main.java;

import java.util.Date;

public class Booking {

    private int userId;
    private int roomNumber;
    private RoomType roomTypeAtBooking;
    private int priceAtBooking;
    private Date checkIn;
    private Date checkOut;

    public Booking(int userId, int roomNumber, RoomType roomTypeAtBooking, int priceAtBooking,
                   Date checkIn, Date checkOut) {
        this.userId = userId;
        this.roomNumber = roomNumber;
        this.roomTypeAtBooking = roomTypeAtBooking;
        this.priceAtBooking = priceAtBooking;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getUserId() {
        return userId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomTypeAtBooking() {
        return roomTypeAtBooking;
    }

    public int getPriceAtBooking() {
        return priceAtBooking;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    @Override
    public String toString() {
        return "Booking | User: " + userId
                + " | Room: " + roomNumber
                + " | Type (at booking): " + roomTypeAtBooking
                + " | Price/night (at booking): " + priceAtBooking
                + " | From: " + checkIn
                + " | To: " + checkOut;
    }
}
