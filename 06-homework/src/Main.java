import Library.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1)
        LeapYearChecker isLeapYear = year ->
                (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        System.out.println("2024 is leap year: " + isLeapYear.check(2024));
        System.out.println("2023 is leap year: " + isLeapYear.check(2023));

        DaysBetweenCalculator daysBetween = ChronoUnit.DAYS::between;

        LocalDate startDate = LocalDate.of(2023, 12, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        System.out.println("Days between " + startDate + " and " + endDate + ": " +
                daysBetween.calculate(startDate, endDate));

        FullWeeksCalculator fullWeeksBetween = (date1, date2) -> {
            LocalDate start = date1.with(DayOfWeek.MONDAY);
            LocalDate end = date2.with(DayOfWeek.SUNDAY);
            return ChronoUnit.WEEKS.between(start, end);
        };

        System.out.println("Full weeks between " + startDate + " and " + endDate + ": " +
                fullWeeksBetween.calculate(startDate, endDate));

        DayOfWeekCalculator dayOfWeekCalculator = date ->
                date.getDayOfWeek().toString();

        LocalDate moonLandingDate = LocalDate.of(1969, 7, 20);
        System.out.println("July 20, 1969 was a " +
                dayOfWeekCalculator.getDay(moonLandingDate));

        // 2)
        MaxOfFour maxOfFour = (a, b, c, d) -> Math.max(Math.max(a, b), Math.max(c, d));

        System.out.println("Max of 10, 20, 5, 15: " + maxOfFour.find(10, 20, 5, 15));
        System.out.println("Max of -3, -7, -1, -5: " + maxOfFour.find(-3, -7, -1, -5));

        MinOfFour minOfFour = (a, b, c, d) -> Math.min(Math.min(a, b), Math.min(c, d));

        System.out.println("Min of 10, 20, 5, 15: " + minOfFour.find(10, 20, 5, 15));
        System.out.println("Min of -3, -7, -1, -5: " + minOfFour.find(-3, -7, -1, -5));

        // 3)
        int[] array = {10, -5, 20, 15, -10, 30, 5};

        int number = 15;
        System.out.println("Sum of elements equal to " + number + ": " +
                calculateSum(array, x -> x == number));

        int A = 10, B = 20;
        System.out.println("Sum of elements not in range [" + A + ", " + B + "]: " +
                calculateSum(array, x -> x < A || x > B));

        System.out.println("Sum of positive elements: " +
                calculateSum(array, x -> x > 0));

        System.out.println("Sum of negative elements: " +
                calculateSum(array, x -> x < 0));

        // 4)
        LibraryCatalog catalog = new LibraryCatalog();

        catalog.addItem(new Book("George Orwell", "1984", "Dystopia", 328));
        catalog.addItem(new Newspaper("The Times", "2024-12-15", Arrays.asList("Headline 1", "Headline 2")));
        catalog.addItem(new Almanac("Best Works 2024", List.of(
                new Book("Gabriel Garcia Marquez", "One Hundred Years of Solitude", "Novel", 417),
                new Book("Jane Austen", "Pride and Prejudice", "Novel", 432)
        )));

        catalog.addRandomItem();

        System.out.println("\nEntire catalog:");
        catalog.displayAllItems();

        System.out.println("\nSearch by title '1984':");
        catalog.searchByTitle("1984");

        System.out.println("\nSearch by author 'George Orwell':");
        catalog.searchByAuthor("George Orwell");

        System.out.println("\nRemoving item with title '1984':");
        catalog.removeItemByTitle("1984");

        System.out.println("\nCatalog after removal:");
        catalog.displayAllItems();
    }

    // 1)
    @FunctionalInterface
    interface LeapYearChecker {
        boolean check(int year);
    }

    @FunctionalInterface
    interface DaysBetweenCalculator {
        long calculate(LocalDate date1, LocalDate date2);
    }

    @FunctionalInterface
    interface FullWeeksCalculator {
        long calculate(LocalDate date1, LocalDate date2);
    }

    @FunctionalInterface
    interface DayOfWeekCalculator {
        String getDay(LocalDate date);
    }

    // 2)
    @FunctionalInterface
    interface MaxOfFour {
        int find(int a, int b, int c, int d);
    }

    @FunctionalInterface
    interface MinOfFour {
        int find(int a, int b, int c, int d);
    }

    // 3)
    public static int calculateSum(int[] array, Condition condition) {
        int sum = 0;
        for (int num : array) {
            if (condition.test(num)) {
                sum += num;
            }
        }
        return sum;
    }

    @FunctionalInterface
    interface Condition {
        boolean test(int value);
    }
}