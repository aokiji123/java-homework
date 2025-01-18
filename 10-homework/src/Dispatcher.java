import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class Dispatcher {
    private List<Driver> drivers;
    private List<Vehicle> vehicles;
    private List<String> logs;

    public Dispatcher(List<Driver> drivers, List<Vehicle> vehicles) {
        this.drivers = drivers;
        this.vehicles = vehicles;
        this.logs = new ArrayList<>();
    }

    public void assignRoute(Route route) {
        Driver assignedDriver = null;
        Vehicle assignedVehicle = null;

        for (Driver driver : drivers) {
            if (driver.getExperience() >= 2) {
                assignedDriver = driver;
                break;
            }
        }

        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable() && vehicle.getCapacity() >= route.getCargoWeight()) {
                assignedVehicle = vehicle;
                break;
            }
        }

        if (assignedDriver != null && assignedVehicle != null) {
            assignedVehicle.setAvailable(false);
            assignedDriver.incrementCargoCount();
            double payment = route.getDistance() * 5;
            assignedDriver.addEarnings(payment);

            logTrip(assignedDriver, assignedVehicle, route);

            System.out.println("Route assigned: " + route + " | Driver: " + assignedDriver.getName() + " | Vehicle: " + assignedVehicle.getModel());
        } else {
            System.out.println("No suitable driver or vehicle available for the route: " + route);
        }
    }

    private void logTrip(Driver driver, Vehicle vehicle, Route route) {
        String logEntry = LocalDateTime.now() + " - Route: " + route + " | Driver: " + driver + " | Vehicle: " + vehicle;
        logs.add(logEntry);
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(logEntry + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    public void printStatistics() {
        System.out.println("=== Statistics ===");
        drivers.sort(Comparator.comparingDouble(Driver::getEarnings).reversed());

        for (Driver driver : drivers) {
            System.out.println(driver);
        }
    }
}