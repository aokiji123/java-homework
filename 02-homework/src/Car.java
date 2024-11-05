public class Car {
    private String model;
    private String manufacturer;
    private int year;
    private double engineVolume;

    public Car() {}

    public Car(String model, String manufacturer, int year, double engineVolume) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.engineVolume = engineVolume;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getYear() {
        return year;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public void displayInfo() {
        System.out.println("Модель автомобіля: " + model);
        System.out.println("Виробник: " + manufacturer);
        System.out.println("Рік випуску: " + year);
        System.out.println("Об’єм двигуна: " + engineVolume + " л");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Car)) return false;
        Car other = (Car) obj;
        return model.equals(other.model) && manufacturer.equals(other.manufacturer);
    }

    @Override
    public int hashCode() {
        return model.hashCode() + manufacturer.hashCode();
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                ", engineVolume=" + engineVolume +
                '}';
    }
}