import java.util.HashMap;

abstract class Room {
    String type;
    double price;

    Room(String type, double price) {
        this.type = type;
        this.price = price;
    }

    void display() {
        System.out.println("Room Type: " + type + " | Price: ₹" + price);
    }
}

class SingleRoom extends Room {
    SingleRoom() {
        super("Single Room", 2000);
    }
}

class DoubleRoom extends Room {
    DoubleRoom() {
        super("Double Room", 3500);
    }
}

class SuiteRoom extends Room {
    SuiteRoom() {
        super("Suite Room", 7000);
    }
}

class RoomInventory {
    private HashMap<String, Integer> inventory;

    RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 0);
        inventory.put("Suite Room", 2);
    }

    int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }
}

class RoomSearchService {
    void search(Room[] rooms, RoomInventory inventory) {
        for (Room r : rooms) {
            int available = inventory.getAvailability(r.type);
            if (available > 0) {
                r.display();
                System.out.println("Available: " + available);
            }
        }
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        Room[] rooms = {
                new SingleRoom(),
                new DoubleRoom(),
                new SuiteRoom()
        };

        RoomInventory inventory = new RoomInventory();
        RoomSearchService searchService = new RoomSearchService();

        System.out.println("Book My Stay App - Version 4.1");
        System.out.println("Available Rooms:\n");

        searchService.search(rooms, inventory);
    }
}