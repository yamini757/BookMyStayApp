import java.util.*;

class Reservation {
    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

class RoomInventory {
    private HashMap<String, Integer> inventory = new HashMap<>();

    RoomInventory() {
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 2);
        inventory.put("Suite Room", 1);
    }

    int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    void decrease(String type) {
        inventory.put(type, inventory.get(type) - 1);
    }
}

class BookingService {

    private HashMap<String, Set<String>> allocatedRooms = new HashMap<>();
    private Set<String> allRoomIds = new HashSet<>();
    private int idCounter = 1;

    void process(Queue<Reservation> queue, RoomInventory inventory) {

        while (!queue.isEmpty()) {

            Reservation r = queue.poll();

            if (inventory.getAvailability(r.roomType) > 0) {

                String roomId = r.roomType.replace(" ", "") + "-" + idCounter++;

                while (allRoomIds.contains(roomId)) {
                    roomId = r.roomType.replace(" ", "") + "-" + idCounter++;
                }

                allRoomIds.add(roomId);

                allocatedRooms
                        .computeIfAbsent(r.roomType, k -> new HashSet<>())
                        .add(roomId);

                inventory.decrease(r.roomType);

                System.out.println("Reservation Confirmed: " + r.guestName +
                        " | " + r.roomType +
                        " | Room ID: " + roomId);

            } else {
                System.out.println("Reservation Failed (No Availability): " +
                        r.guestName + " | " + r.roomType);
            }
        }
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        Queue<Reservation> queue = new LinkedList<>();

        queue.add(new Reservation("Amit", "Single Room"));
        queue.add(new Reservation("Riya", "Double Room"));
        queue.add(new Reservation("Karan", "Suite Room"));
        queue.add(new Reservation("Neha", "Suite Room"));

        RoomInventory inventory = new RoomInventory();
        BookingService service = new BookingService();

        System.out.println("Book My Stay App - Version 6.1\n");

        service.process(queue, inventory);
    }
}