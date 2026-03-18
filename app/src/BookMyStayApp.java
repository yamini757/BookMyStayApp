import java.util.*;

class AddOnService {
    String name;
    double price;

    AddOnService(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class AddOnServiceManager {

    private Map<String, List<AddOnService>> serviceMap = new HashMap<>();

    void addService(String reservationId, AddOnService service) {
        serviceMap.computeIfAbsent(reservationId, k -> new ArrayList<>()).add(service);
    }

    double calculateTotal(String reservationId) {
        double total = 0;
        List<AddOnService> list = serviceMap.getOrDefault(reservationId, new ArrayList<>());
        for (AddOnService s : list) {
            total += s.price;
        }
        return total;
    }

    void displayServices(String reservationId) {
        List<AddOnService> list = serviceMap.getOrDefault(reservationId, new ArrayList<>());
        for (AddOnService s : list) {
            System.out.println(s.name + " : ₹" + s.price);
        }
        System.out.println("Total Add-On Cost: ₹" + calculateTotal(reservationId));
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        AddOnServiceManager manager = new AddOnServiceManager();

        String reservationId = "RES-101";

        manager.addService(reservationId, new AddOnService("Breakfast", 500));
        manager.addService(reservationId, new AddOnService("Airport Pickup", 1200));
        manager.addService(reservationId, new AddOnService("Spa Access", 1500));

        System.out.println("Book My Stay App - Version 7.1\n");

        System.out.println("Services for Reservation: " + reservationId);
        manager.displayServices(reservationId);
    }
}