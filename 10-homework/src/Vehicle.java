public class Vehicle {
    private String model;
    private double capacity;
    private boolean available;

    public Vehicle(String model, double capacity) {
        this.model = model;
        this.capacity = capacity;
        this.available = true;
    }

    public String getModel() {
        return model;
    }

    public double getCapacity() {
        return capacity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", capacity=" + capacity +
                ", available=" + available +
                '}';
    }
}