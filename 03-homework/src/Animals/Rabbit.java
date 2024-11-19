package Animals;

public class Rabbit extends Animal {
    public Rabbit(String name, double foodAmount) {
        super(name, foodAmount);
    }

    @Override
    public String makeSound() {
        return "Squeak";
    }

    @Override
    public boolean isPredator() {
        return false;
    }
}
