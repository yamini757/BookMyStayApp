import java.util.*;

public class BookMyStayApp {

    public static void main(String[] args) {

        Map<String, String> bookings = new HashMap<>();
        Map<String, Integer> inventory = new HashMap<>();
        Stack<String> rollback = new Stack<>();

        inventory.put("Single", 1);

        bookings.put("R1", "Single");
        inventory.put("Single", inventory.get("Single") - 1);

        String cancelId = "R1";

        if (bookings.containsKey(cancelId)) {

            String room = bookings.remove(cancelId);
            rollback.push(cancelId);

            inventory.put(room, inventory.get(room) + 1);

            System.out.println("Booking Cancelled: " + cancelId);
            System.out.println("Room Restored: " + room);
        }
        else {
            System.out.println("Cancellation Failed: Reservation not found");
        }

        System.out.println("Current Inventory: " + inventory);
    }
}