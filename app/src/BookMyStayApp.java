import java.util.*;

class BookingService {
    private int rooms = 2;

    synchronized void book(String guest) {
        if (rooms > 0) {
            System.out.println(guest + " booked a room");
            rooms--;
        } else {
            System.out.println("No rooms available for " + guest);
        }
    }
}

class Guest extends Thread {
    BookingService service;
    String name;

    Guest(BookingService s, String name) {
        service = s;
        this.name = name;
    }

    public void run() {
        service.book(name);
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        BookingService service = new BookingService();

        Guest g1 = new Guest(service, "Amit");
        Guest g2 = new Guest(service, "Riya");
        Guest g3 = new Guest(service, "Karan");

        g1.start();
        g2.start();
        g3.start();
    }
}