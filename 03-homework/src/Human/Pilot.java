package Human;

public class Pilot extends Human {
    private String airline;

    public Pilot(String name, int age, int childrenCount, String airline) {
        super(name, age, childrenCount);
        this.airline = airline;
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("Airline: " + airline);
    }
}