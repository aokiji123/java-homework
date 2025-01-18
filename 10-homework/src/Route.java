public class Route {
    private String destination;
    private double distance;
    private String cargoType;
    private double cargoWeight;

    public Route(String destination, double distance, String cargoType, double cargoWeight) {
        this.destination = destination;
        this.distance = distance;
        this.cargoType = cargoType;
        this.cargoWeight = cargoWeight;
    }

    public String getDestination() {
        return destination;
    }

    public double getDistance() {
        return distance;
    }

    public String getCargoType() {
        return cargoType;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }

    @Override
    public String toString() {
        return "Route{" +
                "destination='" + destination + '\'' +
                ", distance=" + distance +
                ", cargoType='" + cargoType + '\'' +
                ", cargoWeight=" + cargoWeight +
                '}';
    }
}
