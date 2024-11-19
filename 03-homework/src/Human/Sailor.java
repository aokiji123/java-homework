package Human;

public class Sailor extends Human {
    private String shipName;

    public Sailor(String name, int age, int childrenCount, String shipName) {
        super(name, age, childrenCount);
        this.shipName = shipName;
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("Ship: " + shipName);
    }
}
