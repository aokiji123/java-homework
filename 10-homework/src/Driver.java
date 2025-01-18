public class Driver {
    private String name;
    private int experience;
    private double earnings;
    private int cargoCount;

    public Driver(String name, int experience) {
        this.name = name;
        this.experience = experience;
        this.earnings = 0;
        this.cargoCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public void addEarnings(double amount) {
        this.earnings += amount;
    }

    public double getEarnings() {
        return earnings;
    }

    public void incrementCargoCount() {
        this.cargoCount++;
    }

    public int getCargoCount() {
        return cargoCount;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                ", earnings=" + earnings +
                ", cargoCount=" + cargoCount +
                '}';
    }
}
