package SeaBoatPier;

public class Boat {
    private int availableSeats;

    public Boat(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void loadPassengers(int passengers) {
        this.availableSeats = Math.max(0, this.availableSeats - passengers);
    }
}

