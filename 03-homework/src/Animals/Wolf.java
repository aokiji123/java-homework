package Animals;

public class Wolf extends Animal {
    public Wolf(String name, double foodAmount) {
        super(name, foodAmount);
    }

    @Override
    public String makeSound() {
        return "Howl";
    }

    @Override
    public boolean isPredator() {
        return true;
    }
}
