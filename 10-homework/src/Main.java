import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("John", 5));
        drivers.add(new Driver("Alice", 3));
        drivers.add(new Driver("Bob", 2));

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("Truck A", 10000));
        vehicles.add(new Vehicle("Van B", 5000));
        vehicles.add(new Vehicle("Truck C", 15000));

        Dispatcher dispatcher = new Dispatcher(drivers, vehicles);

        List<Route> routes = Arrays.asList(
                new Route("City A", 200, "Electronics", 3000),
                new Route("City B", 500, "Furniture", 7000),
                new Route("City C", 100, "Food", 2000)
        );

        for (Route route : routes) {
            dispatcher.assignRoute(route);
        }

        dispatcher.printStatistics();
    }
}