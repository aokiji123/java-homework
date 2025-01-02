import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.nio.file.*;

public class DirectoryCopy {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter path to the existing directory: "); // src/oldDirectory
            String sourceDir = reader.readLine();

            System.out.print("Enter path to the new directory: "); // src/newDirectory
            String targetDir = reader.readLine();

            Path sourcePath = Paths.get(sourceDir);
            Path targetPath = Paths.get(targetDir);

            if (!Files.exists(sourcePath) || !Files.isDirectory(sourcePath)) {
                System.out.println("Directory doesn't exist or this is not a directory.");
                return;
            }

            AtomicInteger filesCopied = new AtomicInteger();
            AtomicInteger dirsCopied = new AtomicInteger();

            Thread copyThread = new Thread(() -> {
                try {
                    Files.walk(sourcePath).forEach(path -> {
                        try {
                            Path relativePath = sourcePath.relativize(path);
                            Path targetSubPath = targetPath.resolve(relativePath);

                            if (Files.isDirectory(path)) {
                                Files.createDirectories(targetSubPath);
                                dirsCopied.incrementAndGet();
                            } else {
                                Files.copy(path, targetSubPath, StandardCopyOption.REPLACE_EXISTING);
                                filesCopied.incrementAndGet();
                            }
                        } catch (IOException e) {
                            System.err.println("Error while copying: " + e.getMessage());
                        }
                    });
                } catch (IOException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            });

            copyThread.start();
            copyThread.join();

            System.out.println("Copying finished.");
            System.out.println("Amount of copied files: " + filesCopied);
            System.out.println("Amount of copied directories: " + dirsCopied);
        } catch (Exception e) {
            System.err.println("There was an error: " + e.getMessage());
        }
    }
}
