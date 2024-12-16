package Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LibraryCatalog {
    private List<LibraryItem> items;

    public LibraryCatalog() {
        items = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void addRandomItem() {
        Random rand = new Random();
        switch (rand.nextInt(3)) {
            case 0 -> addItem(new Book("Author " + rand.nextInt(100), "Book " + rand.nextInt(100), "Genre " + rand.nextInt(5), rand.nextInt(500) + 50));
            case 1 -> addItem(new Newspaper("Newspaper " + rand.nextInt(100), "2024-12-" + (rand.nextInt(30) + 1), Arrays.asList("Headline 1", "Headline 2")));
            case 2 -> addItem(new Almanac("Almanac " + rand.nextInt(100), List.of(new Book("Almanac Author 1", "Work 1", "Genre", 200))));
        }
    }

    public void removeItemByTitle(String title) {
        items.removeIf(item -> item.getTitle().equalsIgnoreCase(title));
    }

    public void displayAllItems() {
        if (items.isEmpty()) {
            System.out.println("The catalog is empty.");
        } else {
            for (LibraryItem item : items) {
                item.displayInfo();
            }
        }
    }

    public void searchByTitle(String title) {
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                item.displayInfo();
                return;
            }
        }
        System.out.println("Item with the title '" + title + "' not found.");
    }

    public void searchByAuthor(String author) {
        boolean found = false;
        for (LibraryItem item : items) {
            if (item instanceof Book && ((Book) item).getAuthor().equalsIgnoreCase(author)) {
                item.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by author '" + author + "'.");
        }
    }
}
