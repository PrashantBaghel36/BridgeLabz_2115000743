import java.io.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.nio.file.*;
public class FileProcessor {

    public static void writeToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }

    public static String readFromFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }
}
public class FileProcessorTest {
    private static final String TEST_FILE = "testfile.txt";

    @AfterEach
    void cleanup() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }

    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello, world!";
        FileProcessor.writeToFile(TEST_FILE, content);
        String readContent = FileProcessor.readFromFile(TEST_FILE);
        assertEquals(content, readContent);
    }

    @Test
    void testFileExistsAfterWrite() throws IOException {
        FileProcessor.writeToFile(TEST_FILE, "Sample content");
        assertTrue(Files.exists(Paths.get(TEST_FILE)));
    }

    @Test
    void testReadNonExistentFile() {
        assertThrows(IOException.class, () -> FileProcessor.readFromFile("nonexistent.txt"));
    }
}
