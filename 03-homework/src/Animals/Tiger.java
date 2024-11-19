package Animals;

public class Tiger extends Animal {
    public Tiger(String name, double foodAmount) {
        super(name, foodAmount);
    }

    @Override
    public String makeSound() {
        return "Roar";
    }

    @Override
    public boolean isPredator() {
        return true;
    }
}