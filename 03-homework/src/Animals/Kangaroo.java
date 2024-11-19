package Animals;

public class Kangaroo extends Animal {
    public Kangaroo(String name, double foodAmount) {
        super(name, foodAmount);
    }

    @Override
    public String makeSound() {
        return "Chortle";
    }

    @Override
    public boolean isPredator() {
        return false;
    }
}
