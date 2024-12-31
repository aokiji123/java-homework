import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        // 1)
        try {
            System.out.print("Enter the path to the 1st file: ");
            String filePath1 = scanner.nextLine();
            System.out.print("Enter the path to the 2nd file: ");
            String filePath2 = scanner.nextLine();

            List<String> file1Lines = Files.readAllLines(Paths.get(filePath1));
            List<String> file2Lines = Files.readAllLines(Paths.get(filePath2));

            System.out.println("Lines, that are not the same in 1st file:");
            file1Lines.stream()
                    .filter(line -> !file2Lines.contains(line))
                    .forEach(System.out::println);

            System.out.println("Lines, that are not the same in 2nd file:");
            file2Lines.stream()
                    .filter(line -> !file1Lines.contains(line))
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("There was an error: " + e.getMessage());
        }

        // 2)
        System.out.println("Enter the path to the file: ");
        String filePath = scanner.nextLine();

        String longestLine = "";
        int maxLength = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() > maxLength) {
                    maxLength = line.length();
                    longestLine = line;
                }
            }

            System.out.println("Length of the longest line: " + maxLength);
            System.out.println("The line itself: " + longestLine);

        } catch (IOException e) {
            System.out.println("There was an error: " + e.getMessage());
        }

        // 3)
        String fileName = "src/file3.txt";
        List<int[]> arrays = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                int[] array = Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                arrays.add(array);
            }
        } catch (IOException e) {
            System.err.println("There was an error: " + e.getMessage());
            return;
        }

        int totalSum = 0;

        for (int i = 0; i < arrays.size(); i++) {
            int[] array = arrays.get(i);
            System.out.println("Array " + (i + 1) + ": " + Arrays.toString(array));

            int max = Arrays.stream(array).max().orElse(Integer.MIN_VALUE);
            int min = Arrays.stream(array).min().orElse(Integer.MAX_VALUE);
            int sum = Arrays.stream(array).sum();

            System.out.println("  Max: " + max);
            System.out.println("  Min: " + min);
            System.out.println("  Sum: " + sum);

            totalSum += sum;
        }

        System.out.println("Total sum: " + totalSum);

        // 4)
        System.out.print("Enter the path to the file: ");
        String filePath2 = scanner.nextLine();

        System.out.print("Enter the array of numbers (with space): ");
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        for (int num : array) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            } else {
                oddNumbers.add(num);
            }
        }

        int[] reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(Arrays.toString(array).replaceAll("[\\[\\],]", ""));
            writer.newLine();

            writer.write(evenNumbers.toString().replaceAll("[\\[\\],]", ""));
            writer.newLine();

            writer.write(oddNumbers.toString().replaceAll("[\\[\\],]", ""));
            writer.newLine();

            writer.write(Arrays.toString(reversedArray).replaceAll("[\\[\\],]", ""));
            writer.newLine();

            System.out.println("Data was successfully written in the file: " + filePath2);
        } catch (IOException e) {
            System.err.println("There was an error: " + e.getMessage());
        }

        // 5)
        System.out.print("Enter the file path to load data: ");
        String filePath3 = scanner.nextLine();

        Corporation corporation = new Corporation(filePath3);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add an employee");
            System.out.println("2. Edit employee details");
            System.out.println("3. Delete an employee");
            System.out.println("4. Search employee by last name");
            System.out.println("5. Display all employees");
            System.out.println("6. Save employees to file");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> corporation.addEmployee();
                case 2 -> corporation.editEmployee();
                case 3 -> corporation.deleteEmployee();
                case 4 -> corporation.searchEmployee();
                case 5 -> corporation.listEmployees();
                case 6 -> corporation.saveEmployees();
                case 7 -> {
                    corporation.saveEmployees();
                    System.out.println("Data saved. Exiting program.");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}