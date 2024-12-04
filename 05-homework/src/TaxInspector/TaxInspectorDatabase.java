package TaxInspector;

import java.util.*;

public class TaxInspectorDatabase {
    private final Map<Integer, Person> database;

    public TaxInspectorDatabase() {
        this.database = new HashMap<>();
    }

    public void addPerson(int id, Person person) {
        if (database.containsKey(id)) {
            System.out.println("Person with this ID already exists.");
        } else {
            database.put(id, person);
            System.out.println("Person added successfully.");
        }
    }

    public void addTaxInfoToPerson(int id, TaxInfo taxInfo) {
        Person person = database.get(id);
        if (person != null) {
            person.addTaxInfo(taxInfo);
            System.out.println("Tax info added successfully.");
        } else {
            System.out.println("Person not found.");
        }
    }

    public void printDatabase() {
        if (database.isEmpty()) {
            System.out.println("Database is empty.");
        } else {
            database.forEach((id, person) -> {
                System.out.println("ID: " + id + "\n" + person);
            });
        }
    }

    public void printById(int id) {
        Person person = database.get(id);
        if (person != null) {
            System.out.println("ID: " + id + "\n" + person);
        } else {
            System.out.println("Person not found.");
        }
    }

    public void printByTaxType(String type) {
        List<Person> result = database.values().stream()
                .filter(person -> person.getTaxes().stream().anyMatch(tax -> tax.getType().equalsIgnoreCase(type)))
                .toList();

        if (result.isEmpty()) {
            System.out.println("No taxes found for type: " + type);
        } else {
            result.forEach(System.out::println);
        }
    }

    public void printByCity(String city) {
        List<Person> result = database.values().stream()
                .filter(person -> person.getTaxes().stream().anyMatch(tax -> tax.getCity().equalsIgnoreCase(city)))
                .toList();

        if (result.isEmpty()) {
            System.out.println("No taxes found for city: " + city);
        } else {
            result.forEach(System.out::println);
        }
    }

    public void removeTaxInfo(int id, TaxInfo taxInfo) {
        Person person = database.get(id);
        if (person != null) {
            if (person.getTaxes().contains(taxInfo)) {
                person.removeTaxInfo(taxInfo);
                System.out.println("Tax info removed successfully.");
            } else {
                System.out.println("Tax info not found for this person.");
            }
        } else {
            System.out.println("Person not found.");
        }
    }

    public void updatePerson(int id, Person updatedPerson) {
        if (database.containsKey(id)) {
            database.put(id, updatedPerson);
            System.out.println("Person updated successfully.");
        } else {
            System.out.println("Person not found.");
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTax Inspector Database Menu:");
            System.out.println("1. Print full database");
            System.out.println("2. Print by ID");
            System.out.println("3. Print by tax type");
            System.out.println("4. Print by city");
            System.out.println("5. Add new person");
            System.out.println("6. Add tax info to person");
            System.out.println("7. Remove tax info");
            System.out.println("8. Update person");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> printDatabase();
                case 2 -> {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    printById(id);
                }
                case 3 -> {
                    System.out.print("Enter tax type: ");
                    String type = scanner.nextLine();
                    printByTaxType(type);
                }
                case 4 -> {
                    System.out.print("Enter city: ");
                    String city = scanner.nextLine();
                    printByCity(city);
                }
                case 5 -> {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    addPerson(id, new Person(name, address));
                }
                case 6 -> {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter tax type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter city: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    addTaxInfoToPerson(id, new TaxInfo(type, city, amount));
                }
                case 7 -> {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter tax info details to remove.");
                    System.out.print("Type: ");
                    String type = scanner.nextLine();
                    System.out.print("City: ");
                    String city = scanner.nextLine();
                    System.out.print("Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    removeTaxInfo(id, new TaxInfo(type, city, amount));
                }
                case 8 -> {
                    System.out.print("Enter ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter updated name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter updated address: ");
                    String address = scanner.nextLine();
                    updatePerson(id, new Person(name, address));
                }
                case 9 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }
}
