abstract class Room {
    String roomType;
    int beds;
    int size;
    double price;

    Room(String roomType, int beds, int size, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    void displayRoomDetails() {
        System.out.println("Room Type: " + roomType);
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sq.ft");
        System.out.println("Price: ₹" + price);
    }
}

class SingleRoom extends Room {
    SingleRoom() {
        super("Single Room", 1, 200, 2000);
    }
}

class DoubleRoom extends Room {
    DoubleRoom() {
        super("Double Room", 2, 350, 3500);
    }
}

class SuiteRoom extends Room {
    SuiteRoom() {
        super("Suite Room", 3, 600, 7000);
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Book My Stay App - Version 2.1");

        Room single = new SingleRoom();
        Room dbl = new DoubleRoom();
        Room suite = new SuiteRoom();

        int singleAvailable = 10;
        int doubleAvailable = 7;
        int suiteAvailable = 3;

        System.out.println("\nSingle Room Details");
        single.displayRoomDetails();
        System.out.println("Available: " + singleAvailable);

        System.out.println("\nDouble Room Details");
        dbl.displayRoomDetails();
        System.out.println("Available: " + doubleAvailable);

        System.out.println("\nSuite Room Details");
        suite.displayRoomDetails();
        System.out.println("Available: " + suiteAvailable);
    }
}