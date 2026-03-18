import java.util.*;

class Reservation {
    String reservationId;
    String guestName;
    String roomType;

    Reservation(String reservationId, String guestName, String roomType) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
    }

    void display() {
        System.out.println("Reservation ID: " + reservationId +
                " | Guest: " + guestName +
                " | Room: " + roomType);
    }
}

class BookingHistory {

    private List<Reservation> history = new ArrayList<>();

    void addReservation(Reservation r) {
        history.add(r);
    }

    List<Reservation> getHistory() {
        return history;
    }
}

class BookingReportService {

    void displayAllBookings(List<Reservation> list) {
        for (Reservation r : list) {
            r.display();
        }
    }

    void summaryReport(List<Reservation> list) {
        Map<String, Integer> count = new HashMap<>();

        for (Reservation r : list) {
            count.put(r.roomType, count.getOrDefault(r.roomType, 0) + 1);
        }

        System.out.println("\nBooking Summary:");
        for (String type : count.keySet()) {
            System.out.println(type + " : " + count.get(type));
        }
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();

        history.addReservation(new Reservation("RES-101", "Amit", "Single Room"));
        history.addReservation(new Reservation("RES-102", "Riya", "Double Room"));
        history.addReservation(new Reservation("RES-103", "Karan", "Suite Room"));
        history.addReservation(new Reservation("RES-104", "Neha", "Single Room"));

        BookingReportService reportService = new BookingReportService();

        System.out.println("Book My Stay App - Version 8.1\n");

        System.out.println("Booking History:");
        reportService.displayAllBookings(history.getHistory());

        reportService.summaryReport(history.getHistory());
    }
}