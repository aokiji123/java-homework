package Library;

import java.util.List;

public class Newspaper implements LibraryItem {
    private String title;
    private String issueDate;
    private List<String> headlines;

    public Newspaper(String title, String issueDate, List<String> headlines) {
        this.title = title;
        this.issueDate = issueDate;
        this.headlines = headlines;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void displayInfo() {
        System.out.println("[Newspaper] Title: " + title + ", Issue Date: " + issueDate + ", Headlines: " + headlines);
    }
}
