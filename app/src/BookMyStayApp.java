import java.util.Queue;
import java.util.LinkedList;

class Reservation {
    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    void display() {
        System.out.println("Guest: " + guestName + " | Requested Room: " + roomType);
    }
}

class BookingRequestQueue {
    private Queue<Reservation> queue;

    BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    void addRequest(Reservation r) {
        queue.add(r);
    }

    void displayRequests() {
        for (Reservation r : queue) {
            r.display();
        }
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        bookingQueue.addRequest(new Reservation("Amit", "Single Room"));
        bookingQueue.addRequest(new Reservation("Riya", "Double Room"));
        bookingQueue.addRequest(new Reservation("Karan", "Suite Room"));

        System.out.println("Book My Stay App - Version 5.1");
        System.out.println("Booking Requests in Queue (FIFO Order):\n");

        bookingQueue.displayRequests();
    }
}