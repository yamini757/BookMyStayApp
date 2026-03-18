import java.util.HashMap;

class RoomInventory {

    private HashMap<String, Integer> inventory;

    RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 10);
        inventory.put("Double Room", 7);
        inventory.put("Suite Room", 3);
    }

    int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    void displayInventory() {
        for (String roomType : inventory.keySet()) {
            System.out.println(roomType + " Available: " + inventory.get(roomType));
        }
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Book My Stay App - Version 3.1");

        RoomInventory inventory = new RoomInventory();

        System.out.println("\nCurrent Room Inventory");
        inventory.displayInventory();

        System.out.println("\nChecking availability for Single Room:");
        System.out.println(inventory.getAvailability("Single Room"));

        System.out.println("\nUpdating Single Room availability to 8");
        inventory.updateAvailability("Single Room", 8);

        System.out.println("\nUpdated Room Inventory");
        inventory.displayInventory();
    }
}