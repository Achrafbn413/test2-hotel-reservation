package main.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Main {

    public static void main(String[] args) throws ParseException {

        Service s = new Service();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

      
        // Create Rooms
      
        s.setRoom(1, RoomType.STANDARD, 1000);
        s.setRoom(2, RoomType.JUNIOR, 2000);
        s.setRoom(3, RoomType.SUITE, 3000);

       
        // Create Users
       
        s.setUser(1, 5000);
        s.setUser(2, 10000);

     
        // Test bookings
      

        // User 1 → Room 2 → 30/06/2026 to 07/07/2026 (7 nights)
        s.bookRoom(
                1,
                2,
                sdf.parse("30/06/2026"),
                sdf.parse("07/07/2026")
        );

        // User 1 → Room 2 → invalid dates
        s.bookRoom(
                1,
                2,
                sdf.parse("07/07/2026"),
                sdf.parse("30/06/2026")
        );

        // User 1 → Room 1 → 07/07/2026 to 08/07/2026 (1 night)
        s.bookRoom(
                1,
                1,
                sdf.parse("07/07/2026"),
                sdf.parse("08/07/2026")
        );

        // User 2 → Room 1 → 07/07/2026 to 09/07/2026 (2 nights)
        s.bookRoom(
                2,
                1,
                sdf.parse("07/07/2026"),
                sdf.parse("09/07/2026")
        );

        // User 2 → Room 3 → 07/07/2026 to 08/07/2026 (1 night)
        s.bookRoom(
                2,
                3,
                sdf.parse("07/07/2026"),
                sdf.parse("08/07/2026")
        );

        // Change Room 1 after bookings

        s.setRoom(1, RoomType.SUITE, 10000);

        // Print final results
  
        System.out.println("\n===== PRINT ALL =====");
        s.printAll();

        System.out.println("\n===== PRINT ALL USERS =====");
        s.printAllUsers();
    }
}
