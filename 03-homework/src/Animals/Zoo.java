package Animals;

public class Zoo {
    private Animal[] animals;
    private int animalCount;

    public Zoo(int capacity) {
        animals = new Animal[capacity];
        animalCount = 0;
    }

    public void addAnimal(Animal animal) {
        if (animalCount < animals.length) {
            animals[animalCount] = animal;
            animalCount++;
        } else {
            System.out.println("Zoo is full, cannot add more animals.");
        }
    }

    public int countPredators() {
        int count = 0;
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].isPredator()) {
                count++;
            }
        }
        return count;
    }

    public double totalFoodAmount() {
        double totalFood = 0;
        for (int i = 0; i < animalCount; i++) {
            totalFood += animals[i].getFoodAmount();
        }
        return totalFood;
    }

    public void showAnimals() {
        for (int i = 0; i < animalCount; i++) {
            System.out.println(animals[i].getName() + " makes sound: " + animals[i].makeSound());
        }
    }
}
