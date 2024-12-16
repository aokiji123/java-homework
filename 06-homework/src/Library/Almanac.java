package Library;

import java.util.List;

public class Almanac implements LibraryItem {
    private String title;
    private List<Book> books;

    public Almanac(String title, List<Book> books) {
        this.title = title;
        this.books = books;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void displayInfo() {
        System.out.println("[Almanac] Title: " + title);
        System.out.println("Works:");
        for (Book book : books) {
            System.out.println("  - " + book.getTitle() + " (" + book.getAuthor() + ")");
        }
    }
}
