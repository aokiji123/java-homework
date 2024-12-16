package Library;

public class Book implements LibraryItem {
    private String author;
    private String title;
    private String genre;
    private int pageCount;

    public Book(String author, String title, String genre, int pageCount) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.pageCount = pageCount;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void displayInfo() {
        System.out.println("[Book] Author: " + author + ", Title: " + title + ", Genre: " + genre + ", Page Count: " + pageCount);
    }
}