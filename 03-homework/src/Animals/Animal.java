package Animals;

public abstract class Animal {
    private String name;
    private double foodAmount;

    public Animal(String name, double foodAmount) {
        this.name = name;
        this.foodAmount = foodAmount;
    }

    public String getName() {
        return name;
    }

    public double getFoodAmount() {
        return foodAmount;
    }

    public abstract String makeSound();

    public abstract boolean isPredator();

    @Override
    public String toString() {
        return "Animal{name='" + name + "', foodAmount=" + foodAmount + "}";
    }
}
