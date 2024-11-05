import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1)
        List<String> cities = new ArrayList<>();
        cities.add("Київ");
        cities.add("Львів");
        cities.add("Одеса");

        Country country = new Country("Україна", "Європа", 41000000, "+380", "Київ", cities);

        country.displayInfo();

        System.out.println("\nІнформація про місто: " + country.toString());
        System.out.println();

        // 2)
        Book book = new Book("1984", "Джордж Орвелл", 1949, "Secker & Warburg", "Антиутопія", 328);

        book.displayInfo();

        System.out.println("\nІнформація про книгу: " + book.toString());
        System.out.println();

        // 3)
        Car car = new Car("Model S", "Tesla", 2020, 3.0);

        car.displayInfo();

        System.out.println("\nІнформація про автомобіль: " + car.toString());
    }
}