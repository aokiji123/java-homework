import java.util.*;
import java.util.concurrent.*;

public class MultiThreadArray {
    public static void main(String[] args) throws InterruptedException {
        final int ARRAY_SIZE = 10;
        int[] array = new int[ARRAY_SIZE];

        CountDownLatch latch = new CountDownLatch(1);

        Thread arrayFiller = new Thread(() -> {
            Random random = new Random();
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(100);
            }
            System.out.println("Array is full.");
            latch.countDown();
        });

        Thread sumCalculator = new Thread(() -> {
            try {
                latch.await();
                int sum = 0;
                for (int value : array) {
                    sum += value;
                }
                System.out.println("Sum of the array: " + sum);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("There was an error.");
            }
        });

        Thread averageCalculator = new Thread(() -> {
            try {
                latch.await();
                int sum = 0;
                for (int value : array) {
                    sum += value;
                }
                double average = (double) sum / array.length;
                System.out.println("Average of the array: " + average);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("There was an error.");
            }
        });

        arrayFiller.start();
        sumCalculator.start();
        averageCalculator.start();

        arrayFiller.join();
        sumCalculator.join();
        averageCalculator.join();

        System.out.print("Array: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
