import java.io.*;
import java.util.*;

class DataStore implements Serializable {
    Map<String,Integer> inventory = new HashMap<>();
    List<String> bookings = new ArrayList<>();
}

public class BookMyStayApp {

    public static void main(String[] args) {

        String file = "hotel.dat";
        DataStore data = new DataStore();

        data.inventory.put("Single",5);
        data.inventory.put("Double",3);
        data.bookings.add("R1-Amit");
        data.bookings.add("R2-Riya");

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(data);
            out.close();
            System.out.println("Data saved.");
        } catch(Exception e) {
            System.out.println("Save error");
        }

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            DataStore restored = (DataStore) in.readObject();
            in.close();

            System.out.println("Recovered Inventory: " + restored.inventory);
            System.out.println("Recovered Bookings: " + restored.bookings);
        } catch(Exception e) {
            System.out.println("Recovery failed.");
        }
    }
}