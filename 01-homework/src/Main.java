import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

//        1)
//        System.out.print("Enter first number: ");
//        int num1 = scanner.nextInt();
//
//        System.out.print("Enter second number: ");
//        int num2 = scanner.nextInt();
//
//        System.out.print("Enter third number: ");
//        int num3 = scanner.nextInt();
//
//        String result = "" + num1 + num2 + num3;
//
//        int finalNumber = Integer.parseInt(result);
//
//        System.out.println("Final number: " + finalNumber);

//        2)
//        System.out.print("Enter number: ");
//        int num = scanner.nextInt();
//
//        System.out.print("Enter percent: ");
//        int percent = scanner.nextInt();
//
//        double finalNumber = num * percent * 0.01;
//
//        System.out.println("Final number: " + finalNumber);

//        3)
//        System.out.print("Enter the number with 6 digits: ");
//        String input = scanner.nextLine();
//
//        if (input.length() != 6) {
//            System.out.println("Error: the number doesn't contain 6 digits: ");
//        } else {
//            String result = "" + input.charAt(5) + input.charAt(4) + input.charAt(2)
//                    + input.charAt(3) + input.charAt(1) + input.charAt(0);
//
//            System.out.println("Final number: " + result);
//        }

//        4)
//        System.out.print("Enter month number (1-12): ");
//        int month = scanner.nextInt();
//
//        if (month < 1 || month > 12) {
//            System.out.println("Error: you need to enter a number in range from 1 to 12");
//        } else if (month == 12 || month == 1 || month == 2) {
//            System.out.println("Winter");
//        } else if (month >= 3 && month <= 5) {
//            System.out.println("Spring");
//        } else if (month >= 6 && month <= 8) {
//            System.out.println("Summer");
//        } else if (month >= 9 && month <= 11) {
//            System.out.println("Autumn");
//        }

//        5)
//        int[] array = {1, 2, 3, 4, 5};
//        int minIndex = 0;
//        int maxIndex = 0;
//
//        for (int i = 1; i < array.length; i++) {
//            if (array[i] < array[minIndex]) {
//                minIndex = i;
//            }
//            if (array[i] > array[maxIndex]) {
//                maxIndex = i;
//            }
//        }
//
//        int start = Math.min(minIndex, maxIndex) + 1;
//        int end = Math.max(minIndex, maxIndex);
//
//        for (int i = start; i < end; i++) {
//            array[i] *= 2;
//        }
//
//        System.out.println("Array after changes:");
//        for (int num : array) {
//            System.out.print(num + " ");
//        }

//        6)
//        System.out.print("Enter first number: ");
//        int start = scanner.nextInt();
//
//        System.out.print("Enter second number: ");
//        int end = scanner.nextInt();
//
//        if (start > end) {
//            int temp = start;
//            start = end;
//            end = temp;
//        }
//
//        System.out.println("Odd number in range from " + start + " to " + end + ":");
//        for (int i = start; i <= end; i++) {
//            if (i % 2 != 0) {
//                System.out.print(i + " ");
//            }
//        }

//        7)
//        int[] array = new int[random.nextInt(0, 20)];
//
//        for (int i = 0; i < array.length; i++) {
//            array[i] = random.nextInt(-10, 11);
//        }
//
//        int negativeCount = 0;
//        int positiveCount = 0;
//        int zeroCount = 0;
//
//        for (int num : array) {
//            if (num < 0) {
//                negativeCount++;
//            } else if (num > 0) {
//                positiveCount++;
//            } else {
//                zeroCount++;
//            }
//        }
//
//        System.out.println("Array:");
//        for (int num : array) {
//            System.out.print(num + " ");
//        }
//        System.out.println("\nAmount of negative values: " + negativeCount);
//        System.out.println("Amount of positive values: " + positiveCount);
//        System.out.println("Amount of zeroes: " + zeroCount);

//        8)
//        System.out.print("Enter amount of people: ");
//        int people = scanner.nextInt();
//        double totalCost = 0;
//
//        for (int i = 0; i < people; i++) {
//            System.out.println("Menu for a person " + (i + 1) + ":");
//            double personTotal = 0;
//            boolean ordering = true;
//
//            while (ordering) {
//                System.out.println("1. Coffee - 3$.\n2. Cake - 5$.\n3. Croissant - 4$.\n4. Exit");
//                int choice = scanner.nextInt();
//                switch (choice) {
//                    case 1 -> {
//                        personTotal += 3.0;
//                        System.out.println("Coffee is added to the order.");
//                    }
//                    case 2 -> {
//                        personTotal += 5.0;
//                        System.out.println("Cake is added to the order.");
//                    }
//                    case 3 -> {
//                        personTotal += 4.0;
//                        System.out.println("Croissant is added to the order.");
//                    }
//                    case 4 -> ordering = false;
//                    default -> System.out.println("Your input is incorrect. Try again.");
//                }
//            }
//            System.out.println("Final payment for a person " + (i + 1) + ": " + personTotal + "$.");
//            totalCost += personTotal;
//        }
//        System.out.println("Final payment for the company: " + totalCost + "$.");

//        9)
//        System.out.print("Enter how you wanna create an array:\n1. Random numbers\n2. Entering through the coma\nEnter 1 or 2: ");
//        int choice = scanner.nextInt();
//
//        System.out.print("Enter the amount of rows in an array: ");
//        int rows = scanner.nextInt();
//        int[][] array;
//
//        if (choice == 1) {
//            System.out.print("Enter the amount of elements in every row: ");
//            int columns = scanner.nextInt();
//            array = new int[rows][columns];
//            for (int i = 0; i < rows; i++) {
//                for (int j = 0; j < columns; j++) {
//                    array[i][j] = random.nextInt(-10, 11);
//                }
//            }
//        } else {
//            array = new int[rows][];
//            scanner.nextLine();
//            for (int i = 0; i < rows; i++) {
//                System.out.print("Enter the elements of the row " + (i + 1) + " through coma: ");
//                String line = scanner.nextLine();
//                String[] stringNumbers = line.split(",");
//                array[i] = new int[stringNumbers.length];
//                for (int j = 0; j < stringNumbers.length; j++) {
//                    array[i][j] = Integer.parseInt(stringNumbers[j].trim());
//                }
//            }
//        }
//
//        System.out.println("Two-dimensional array:");
//        for (int[] row : array) {
//            for (int num : row) {
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        }
//
//        double[] ratioArray = new double[rows];
//        for (int i = 0; i < rows; i++) {
//            int zeroCount = 0;
//            int nonZeroCount = 0;
//            for (int num : array[i]) {
//                if (num == 0) {
//                    zeroCount++;
//                } else {
//                    nonZeroCount++;
//                }
//            }
//            ratioArray[i] = nonZeroCount == 0 ? 0 : (double) zeroCount / nonZeroCount;
//        }
//
//        System.out.println("The ratio of the number of zero elements to non-zero elements:");
//        for (double ratio : ratioArray) {
//            System.out.printf("%.2f ", ratio);
//        }

//        10)
//        int length = 20;
//        int[] arr = new int[length];
//
//        for (int i = 0; i < length; i++) {
//            arr[i] = random.nextInt(-50, 51);
//        }
//
//        System.out.println("Original array:");
//        for (int num : arr) {
//            System.out.print(num + " ");
//        }
//        System.out.println();
//
//        int evenCount = 0, oddCount = 0, negativeCount = 0, positiveCount = 0;
//
//        for (int num : arr) {
//            if (num % 2 == 0) evenCount++;
//            if (num % 2 != 0) oddCount++;
//            if (num < 0) negativeCount++;
//            if (num > 0) positiveCount++;
//        }
//
//        int[] even = new int[evenCount];
//        int[] odd = new int[oddCount];
//        int[] negative = new int[negativeCount];
//        int[] positive = new int[positiveCount];
//
//        evenCount = oddCount = negativeCount = positiveCount = 0;
//
//        for (int num : arr) {
//            if (num % 2 == 0) even[evenCount++] = num;
//            if (num % 2 != 0) odd[oddCount++] = num;
//            if (num < 0) negative[negativeCount++] = num;
//            if (num > 0) positive[positiveCount++] = num;
//        }
//
//        int[][] categorizedArray = new int[][]{even, odd, negative, positive};
//
//        String[] categories = {"Even numbers", "Odd numbers", "Negative numbers", "Positive numbers"};
//        for (int i = 0; i < categorizedArray.length; i++) {
//            System.out.print(categories[i] + ": ");
//            for (int num : categorizedArray[i]) {
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        }

//        11)
//        System.out.print("Enter the start of range: ");
//        int lowerBound = scanner.nextInt();
//        System.out.print("Enter the end of range: ");
//        int upperBound = scanner.nextInt();
//
//        int sum = calculateSumInRange(lowerBound, upperBound);
//
//        System.out.println("Sum of the range from " + lowerBound + " to " + upperBound + " is: " + sum);

//        12)
//        double[] array = {1.2, 0.5, 7.0, 2.6, 5.0};
//        double[] orderedArray = reorderRelativeToMax(array);
//        for (double num : orderedArray) {
//            System.out.print(num + " ");
//        }
    }

    public static int calculateSumInRange(int lower, int upper) {
        int sum = 0;

        if (lower > upper) {
            int temp = lower;
            lower = upper;
            upper = temp;
        }

        for (int i = lower; i <= upper; i++) {
            sum += i;
        }

        return sum;
    }

    public static double[] reorderRelativeToMax(double[] array) {
        double max = array[0];
        for (double num : array) {
            if (num > max) max = num;
        }

        double[] result = new double[array.length];
        int left = 0;
        int right = array.length - 1;

        for (double num : array) {
            if (num < max) {
                result[left++] = num;
            } else {
                result[right--] = num;
            }
        }

        for (int i = 0; i < left - 1; i++) {
            for (int j = 0; j < left - 1 - i; j++) {
                if (result[j] > result[j + 1]) {
                    double temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }

        return result;
    }
}