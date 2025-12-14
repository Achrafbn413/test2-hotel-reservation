package main.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) throws ParseException {

        Service s = new Service();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Create rooms
        s.setRoom(1, RoomType.STANDARD, 1000);
        s.setRoom(2, RoomType.JUNIOR, 2000);
        s.setRoom(3, RoomType.SUITE, 3000);

        // Create users
        s.setUser(1, 5000);
        s.setUser(2, 10000);

        // Test bookings
        s.bookRoom(1, 2, sdf.parse("30/06/2026"), sdf.parse("07/07/2026"));
        s.bookRoom(1, 2, sdf.parse("07/07/2026"), sdf.parse("30/06/2026"));
        s.bookRoom(1, 1, sdf.parse("07/07/2026"), sdf.parse("08/07/2026"));
        s.bookRoom(2, 1, sdf.parse("07/07/2026"), sdf.parse("09/07/2026"));
        s.bookRoom(2, 3, sdf.parse("07/07/2026"), sdf.parse("08/07/2026"));

        // Update room after bookings
        s.setRoom(1, RoomType.SUITE, 10000);

        // Print results
        System.out.println("\n===== PRINT ALL =====");
        s.printAll();

        System.out.println("\n===== PRINT ALL USERS =====");
        s.printAllUsers();
    }
}
