import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1)
        List<Integer> randomNumbers = new Random()
                .ints(100, -1000, 1000)
                .boxed()
                .toList();

        System.out.println("Generated numbers: " + randomNumbers);

        long positiveCount = randomNumbers.stream()
                .filter(n -> n > 0)
                .count();
        System.out.println("Amount of positive numbers: " + positiveCount);

        long negativeCount = randomNumbers.stream()
                .filter(n -> n < 0)
                .count();
        System.out.println("Amount of negative numbers: " + negativeCount);

        long twoDigitCount = randomNumbers.stream()
                .filter(n -> Math.abs(n) >= 10 && Math.abs(n) < 100)
                .count();
        System.out.println("Amount of two digit numbers: " + twoDigitCount);

        long mirroredCount = randomNumbers.stream()
                .filter(Main::isMirrored)
                .count();
        System.out.println("Amount of mirrored numbers: " + mirroredCount);

        // 2)
        List<String> products = Arrays.asList(
                "Milk", "Bread", "Cheese", "Milk", "Apple", "Juice", "Butter", "Yogurt", "Cream", "Milk", "Eggs", "Olive"
        );

        System.out.println("All products: ");
        products.stream().forEach(System.out::println);

        System.out.println("\nProducts with names shorter than 5 characters: ");
        products.stream()
                .filter(p -> p.length() < 5)
                .forEach(System.out::println);

        System.out.print("\nEnter product name to count: ");
        String userInput = scanner.nextLine();
        long count = products.stream()
                .filter(p -> p.equalsIgnoreCase(userInput))
                .count();
        System.out.println("The product '" + userInput + "' appears " + count + " times.");

        System.out.print("\nEnter the starting letter: ");
        String startingLetter = scanner.nextLine().toUpperCase();
        System.out.println("Products starting with '" + startingLetter + "':");
        products.stream()
                .filter(p -> p.toUpperCase().startsWith(startingLetter))
                .forEach(System.out::println);

        System.out.println("\nProducts in the 'Milk' category:");
        products.stream()
                .filter(p -> p.equalsIgnoreCase("Milk"))
                .forEach(System.out::println);

        // 3)
        List<Device> devices = Arrays.asList(
                new Device("Laptop", 2020, 1200.0, "Black", "Electronics"),
                new Device("Smartphone", 2022, 800.0, "White", "Electronics"),
                new Device("Refrigerator", 2019, 1500.0, "Silver", "Appliance"),
                new Device("Washing Machine", 2021, 900.0, "White", "Appliance"),
                new Device("Tablet", 2023, 600.0, "Black", "Electronics"),
                new Device("Microwave", 2018, 300.0, "Black", "Appliance"),
                new Device("TV", 2020, 1100.0, "Silver", "Electronics")
        );

        System.out.println("All devices:");
        devices.stream().forEach(System.out::println);

        System.out.print("\nEnter color to filter devices: ");
        String color = scanner.nextLine();
        System.out.println("Devices of color '" + color + "':");
        devices.stream()
                .filter(d -> d.getColor().equalsIgnoreCase(color))
                .forEach(System.out::println);

        System.out.print("\nEnter year to filter devices: ");
        int year = scanner.nextInt();
        System.out.println("Devices from year " + year + ":");
        devices.stream()
                .filter(d -> d.getYear() == year)
                .forEach(System.out::println);

        System.out.print("\nEnter device price to filter devices more expensive than this price: ");
        double devicePrice = scanner.nextDouble();
        System.out.println("Devices more expensive than $" + devicePrice + ":");
        devices.stream()
                .filter(d -> d.getPrice() > devicePrice)
                .forEach(System.out::println);

        System.out.print("\nEnter type to filter devices: ");
        scanner.nextLine();
        String type = scanner.nextLine();
        System.out.println("Devices of type '" + type + "':");
        devices.stream()
                .filter(d -> d.getType().equalsIgnoreCase(type))
                .forEach(System.out::println);

        System.out.print("\nEnter start year: ");
        int startYear = scanner.nextInt();
        System.out.print("Enter end year: ");
        int endYear = scanner.nextInt();
        System.out.println("Devices released between " + startYear + " and " + endYear + ":");
        devices.stream()
                .filter(d -> d.getYear() >= startYear && d.getYear() <= endYear)
                .forEach(System.out::println);

        // 4)
        List<Projector> projectors = Arrays.asList(
                new Projector("Epson X100", 2023, 1200.0, "Epson"),
                new Projector("BenQ W2700", 2022, 1500.0, "BenQ"),
                new Projector("Optoma HD28", 2023, 900.0, "Optoma"),
                new Projector("Sony VPL-HW45ES", 2020, 2000.0, "Sony"),
                new Projector("ViewSonic PX701", 2021, 800.0, "ViewSonic"),
                new Projector("BenQ TK850", 2023, 1700.0, "BenQ")
        );

        System.out.println("All projectors:");
        projectors.stream().forEach(System.out::println);

        System.out.print("\nEnter manufacturer to filter projectors: ");
        String manufacturer = scanner.nextLine();
        System.out.println("Projectors by '" + manufacturer + "':");
        projectors.stream()
                .filter(p -> p.getManufacturer().equalsIgnoreCase(manufacturer))
                .forEach(System.out::println);

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        System.out.println("\nProjectors from the current year (" + currentYear + "):");
        projectors.stream()
                .filter(p -> p.getYear() == currentYear)
                .forEach(System.out::println);

        System.out.print("\nEnter projector price to filter projectors above this price: ");
        double projectorPrice = scanner.nextDouble();
        System.out.println("Projectors priced above $" + projectorPrice + ":");
        projectors.stream()
                .filter(p -> p.getPrice() > projectorPrice)
                .forEach(System.out::println);

        System.out.println("\nProjectors sorted by price (ascending):");
        projectors.stream()
                .sorted(Comparator.comparingDouble(Projector::getPrice))
                .forEach(System.out::println);

        System.out.println("\nProjectors sorted by price (descending):");
        projectors.stream()
                .sorted(Comparator.comparingDouble(Projector::getPrice).reversed())
                .forEach(System.out::println);

        System.out.println("\nProjectors sorted by year (ascending):");
        projectors.stream()
                .sorted(Comparator.comparingInt(Projector::getYear))
                .forEach(System.out::println);

        System.out.println("\nProjectors sorted by year (descending):");
        projectors.stream()
                .sorted(Comparator.comparingInt(Projector::getYear).reversed())
                .forEach(System.out::println);
    }

    // 1)
    private static boolean isMirrored(int number) {
        String original = String.valueOf(Math.abs(number));
        String reversed = new StringBuilder(original).reverse().toString();
        return original.equals(reversed);
    }
}