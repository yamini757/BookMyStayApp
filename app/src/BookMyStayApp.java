import java.util.*;

class InvalidBookingException extends Exception {
    InvalidBookingException(String msg) {
        super(msg);
    }
}

public class BookMyStayApp {

    static void validateBooking(String roomType, int available) throws InvalidBookingException {
        if(!(roomType.equals("Single") || roomType.equals("Double") || roomType.equals("Suite")))
            throw new InvalidBookingException("Invalid Room Type!");

        if(available <= 0)
            throw new InvalidBookingException("No rooms available!");
    }

    public static void main(String[] args) {

        String roomType = "Single";
        int available = 0;

        try {
            validateBooking(roomType, available);
            System.out.println("Booking Confirmed for " + roomType);
        }
        catch(InvalidBookingException e) {
            System.out.println("Booking Failed: " + e.getMessage());
        }

        System.out.println("System continues running safely.");
    }
}