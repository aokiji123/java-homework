import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class MultiThreadRandomSumAverage {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();
        File file = new File(filePath);

        CyclicBarrier barrier = new CyclicBarrier(3);

        File primesFile = new File("primes.txt");
        File factorialsFile = new File("factorials.txt");

        Thread fillerThread = new Thread(() -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                Random random = new Random();
                for (int i = 0; i < 100; i++) {
                    writer.write(random.nextInt(100) + 1 + "\n");
                }
                System.out.println("File filled with random numbers.");
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread primesThread = new Thread(() -> {
            try {
                barrier.await();
                List<Integer> primes = new ArrayList<>();
                try (BufferedReader reader = new BufferedReader(new FileReader(file));
                     BufferedWriter writer = new BufferedWriter(new FileWriter(primesFile))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        int number = Integer.parseInt(line);
                        if (isPrime(number)) {
                            primes.add(number);
                            writer.write(number + "\n");
                        }
                    }
                }
                System.out.println("Prime numbers found and saved.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread factorialsThread = new Thread(() -> {
            try {
                barrier.await();
                try (BufferedReader reader = new BufferedReader(new FileReader(file));
                     BufferedWriter writer = new BufferedWriter(new FileWriter(factorialsFile))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        int number = Integer.parseInt(line);
                        writer.write(number + "! = " + factorial(number) + "\n");
                    }
                }
                System.out.println("Factorials calculated and saved.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        long startTime = System.currentTimeMillis();

        fillerThread.start();
        primesThread.start();
        factorialsThread.start();

        fillerThread.join();
        primesThread.join();
        factorialsThread.join();

        long endTime = System.currentTimeMillis();
        System.out.println("All operations completed in " + (endTime - startTime) + " ms.");
        System.out.println("Primes saved in: " + primesFile.getAbsolutePath());
        System.out.println("Factorials saved in: " + factorialsFile.getAbsolutePath());
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private static long factorial(int num) {
        if (num == 0 || num == 1) return 1;
        long result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
