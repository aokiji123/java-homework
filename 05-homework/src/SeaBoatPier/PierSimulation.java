package SeaBoatPier;

import java.util.*;

public class PierSimulation {
    private final Queue<Passenger> passengerQueue = new LinkedList<>();
    private final Random random = new Random();

    private final Map<String, Double> passengerArrivalRates = new HashMap<>();
    private final Map<String, Double> boatArrivalRates = new HashMap<>();
    private final int maxPeopleOnPier;

    public PierSimulation(int maxPeopleOnPier) {
        this.maxPeopleOnPier = maxPeopleOnPier;
    }

    public void initializeRates() {
        passengerArrivalRates.put("Morning", 1.5);
        passengerArrivalRates.put("Afternoon", 1.0);
        passengerArrivalRates.put("Evening", 2.0);

        boatArrivalRates.put("Morning", 5.0);
        boatArrivalRates.put("Afternoon", 7.0);
        boatArrivalRates.put("Evening", 10.0);
    }

    public void generatePassengers(double rate, long currentTime) {
        double arrivalInterval = -Math.log(1 - random.nextDouble()) * rate;
        if (arrivalInterval < 1) {
            passengerQueue.add(new Passenger(currentTime));
            System.out.println("A new passenger arrived at the pier at minute " + currentTime + ".");
        }
    }

    public void processBoat(Boat boat, long currentTime) {
        System.out.println("A boat arrived at minute " + currentTime + " with " + boat.getAvailableSeats() + " available seats.");
        int passengersToLoad = Math.min(boat.getAvailableSeats(), passengerQueue.size());
        for (int i = 0; i < passengersToLoad; i++) {
            passengerQueue.poll();
        }
        boat.loadPassengers(passengersToLoad);
        System.out.println(passengersToLoad + " passengers boarded the boat.");
        System.out.println("Remaining passengers on the pier: " + passengerQueue.size() + ".");
    }

    public void simulate(String timeOfDay, long simulationDuration) {
        double passengerRate = passengerArrivalRates.get(timeOfDay);
        double boatRate = boatArrivalRates.get(timeOfDay);

        long currentTime = 0;
        while (currentTime < simulationDuration) {
            generatePassengers(passengerRate, currentTime);

            if (currentTime % boatRate == 0) {
                int availableSeats = random.nextInt(30) + 1;
                Boat boat = new Boat(availableSeats);
                processBoat(boat, currentTime);
            }

            if (passengerQueue.size() > maxPeopleOnPier) {
                System.out.println("The pier is overcrowded with " + passengerQueue.size() + " passengers.");
                break;
            }

            currentTime++;
        }

        System.out.println("Simulation completed.");
    }
}
