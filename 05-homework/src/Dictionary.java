import java.util.*;
import java.util.stream.Collectors;

public class Dictionary {
    private static class WordEntry {
        private final String word;
        private List<String> translations;
        private int accessCount;

        public WordEntry(String word, List<String> translations) {
            this.word = word;
            this.translations = new ArrayList<>(translations);
            this.accessCount = 0;
        }

        public String getWord() {
            return word;
        }

        public List<String> getTranslations() {
            return translations;
        }

        public int getAccessCount() {
            return accessCount;
        }

        public void incrementAccessCount() {
            accessCount++;
        }

        public void setTranslations(List<String> newTranslations) {
            this.translations = new ArrayList<>(newTranslations);
        }

        @Override
        public String toString() {
            return word + " -> " + String.join(", ", translations) + " (Accessed: " + accessCount + ")";
        }
    }

    private final Map<String, WordEntry> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
    }

    public void addWord(String word, List<String> translations) {
        if (dictionary.containsKey(word)) {
            System.out.println("Word already exists. Use updateWord to modify it.");
        } else {
            dictionary.put(word, new WordEntry(word, translations));
            System.out.println("Word added successfully.");
        }
    }

    public void updateWord(String word, List<String> newTranslations) {
        WordEntry entry = dictionary.get(word);
        if (entry != null) {
            entry.setTranslations(newTranslations);
            System.out.println("Word updated successfully.");
        } else {
            System.out.println("Word not found.");
        }
    }

    public void removeWord(String word) {
        if (dictionary.remove(word) != null) {
            System.out.println("Word removed successfully.");
        } else {
            System.out.println("Word not found.");
        }
    }

    public void getWord(String word) {
        WordEntry entry = dictionary.get(word);
        if (entry != null) {
            entry.incrementAccessCount();
            System.out.println(entry);
        } else {
            System.out.println("Word not found.");
        }
    }

    public void displayTop10PopularWords() {
        List<WordEntry> popularWords = dictionary.values().stream()
                .sorted((a, b) -> Integer.compare(b.getAccessCount(), a.getAccessCount()))
                .limit(10)
                .toList();

        System.out.println("Top 10 most popular words:");
        for (WordEntry entry : popularWords) {
            System.out.println(entry);
        }
    }

    public void displayTop10LeastPopularWords() {
        List<WordEntry> leastPopularWords = dictionary.values().stream()
                .sorted(Comparator.comparingInt(WordEntry::getAccessCount))
                .limit(10)
                .toList();

        System.out.println("Top 10 least popular words:");
        for (WordEntry entry : leastPopularWords) {
            System.out.println(entry);
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nDictionary Menu:");
            System.out.println("1. Add word");
            System.out.println("2. Update word translations");
            System.out.println("3. Remove word");
            System.out.println("4. Get word and translations");
            System.out.println("5. Display top 10 most popular words");
            System.out.println("6. Display top 10 least popular words");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("Enter the word: ");
                    String word = scanner.nextLine();
                    System.out.print("Enter translations (comma-separated): ");
                    String translationsInput = scanner.nextLine();
                    List<String> translations = Arrays.asList(translationsInput.split(",\\s*"));
                    addWord(word, translations);
                    break;
                }
                case 2: {
                    System.out.print("Enter the word to update: ");
                    String word = scanner.nextLine();
                    System.out.print("Enter new translations (comma-separated): ");
                    String translationsInput = scanner.nextLine();
                    List<String> translations = Arrays.asList(translationsInput.split(",\\s*"));
                    updateWord(word, translations);
                    break;
                }
                case 3: {
                    System.out.print("Enter the word to remove: ");
                    String word = scanner.nextLine();
                    removeWord(word);
                    break;
                }
                case 4: {
                    System.out.print("Enter the word to retrieve: ");
                    String word = scanner.nextLine();
                    getWord(word);
                    break;
                }
                case 5:
                    displayTop10PopularWords();
                    break;
                case 6:
                    displayTop10LeastPopularWords();
                    break;
                case 7:
                    System.out.println("Exiting the dictionary app. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
