import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class MultiThreadFileSearch {
    private static final String OUTPUT_FILE = "src/merged.txt";
    private static final String FORBIDDEN_WORDS_FILE = "src/forbiddenWords.txt";

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        System.out.print("Enter the word to search: ");
        String searchWord = scanner.nextLine();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CountDownLatch latch = new CountDownLatch(1);
        File mergedFile = new File(OUTPUT_FILE);

        Runnable fileSearchTask = () -> {
            try {
                List<File> matchedFiles = Files.walk(Paths.get(directoryPath))
                        .filter(Files::isRegularFile)
                        .map(Path::toFile)
                        .filter(file -> containsWord(file, searchWord))
                        .collect(Collectors.toList());

                mergeFiles(matchedFiles, mergedFile);
                System.out.println("File merging completed.");
            } catch (IOException e) {
                System.err.println("Error during file search or merge: " + e.getMessage());
            } finally {
                latch.countDown();
            }
        };

        Runnable wordFilterTask = () -> {
            try {
                latch.await();

                List<String> forbiddenWords = Files.readAllLines(Paths.get(FORBIDDEN_WORDS_FILE));
                filterForbiddenWords(mergedFile, forbiddenWords);

                System.out.println("Forbidden words filtering completed.");
            } catch (IOException | InterruptedException e) {
                System.err.println("Error during forbidden words filtering: " + e.getMessage());
            }
        };

        long startTime = System.currentTimeMillis();

        executorService.execute(fileSearchTask);
        executorService.execute(wordFilterTask);

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

        long endTime = System.currentTimeMillis();

        System.out.println("Operations completed in " + (endTime - startTime) + " ms.");
    }

    private static boolean containsWord(File file, String word) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines().anyMatch(line -> line.contains(word));
        } catch (IOException e) {
            System.err.println("Error reading file " + file.getName() + ": " + e.getMessage());
        }
        return false;
    }

    private static void mergeFiles(List<File> files, File outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (File file : files) {
                Files.lines(file.toPath()).forEach(line -> {
                    try {
                        writer.write(line);
                        writer.newLine();
                    } catch (IOException e) {
                        throw new UncheckedIOException(e);
                    }
                });
            }
        } catch (IOException e) {
            System.err.println("Error merging files: " + e.getMessage());
        }
    }

    private static void filterForbiddenWords(File file, List<String> forbiddenWords) {
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (String line : lines) {
                    for (String forbiddenWord : forbiddenWords) {
                        line = line.replaceAll("\\b" + forbiddenWord + "\\b", "");
                    }
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error filtering forbidden words: " + e.getMessage());
        }
    }
}
