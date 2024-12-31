import java.io.*;
import java.util.*;

public class Corporation {
    private List<Employee> employees = new ArrayList<>();
    private final String filePath;
    private final Scanner scanner = new Scanner(System.in);

    public Corporation(String filePath) {
        this.filePath = filePath;
        loadEmployees();
    }

    private void loadEmployees() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    employees.add(new Employee(parts[0], parts[1], Integer.parseInt(parts[2])));
                }
            }
            System.out.println("Data successfully loaded.");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    public void saveEmployees() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Employee employee : employees) {
                writer.write(employee.toFileString());
                writer.newLine();
            }
            System.out.println("Data successfully saved.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public void addEmployee() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());
        employees.add(new Employee(firstName, lastName, age));
        System.out.println("Employee added.");
    }

    public void editEmployee() {
        System.out.print("Enter the last name of the employee to edit: ");
        String lastName = scanner.nextLine();
        Employee employee = findEmployee(lastName);

        if (employee != null) {
            System.out.print("New first name (leave blank to keep current): ");
            String newFirstName = scanner.nextLine();
            if (!newFirstName.isEmpty()) {
                employee.setFirstName(newFirstName);
            }

            System.out.print("New last name (leave blank to keep current): ");
            String newLastName = scanner.nextLine();
            if (!newLastName.isEmpty()) {
                employee.setLastName(newLastName);
            }

            System.out.print("New age (leave blank to keep current): ");
            String newAge = scanner.nextLine();
            if (!newAge.isEmpty()) {
                employee.setAge(Integer.parseInt(newAge));
            }
            System.out.println("Employee details updated.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void deleteEmployee() {
        System.out.print("Enter the last name of the employee to delete: ");
        String lastName = scanner.nextLine();
        Employee employee = findEmployee(lastName);

        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee deleted.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void searchEmployee() {
        System.out.print("Enter the last name to search: ");
        String lastName = scanner.nextLine();
        Employee employee = findEmployee(lastName);

        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void listEmployees() {
        System.out.print("Enter the first letter of the last name (or leave blank for all): ");
        String prefix = scanner.nextLine();

        for (Employee employee : employees) {
            if (prefix.isEmpty() || employee.getLastName().startsWith(prefix)) {
                System.out.println(employee);
            }
        }
    }

    private Employee findEmployee(String lastName) {
        return employees.stream()
                .filter(e -> e.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }
}