import java.io.*;
public class FileReadingComparison {
    public static void main(String[] args) {
        String filePath = "largefile.txt";
        int[] fileSizes = {1, 100, 500}; 
        for (int size : fileSizes) {
            try {
                long startTime = System.nanoTime();
                readWithFileReader(filePath, size);
                long fileReaderTime = System.nanoTime() - startTime;
                startTime = System.nanoTime();
                readWithInputStreamReader(filePath, size);
                long inputStreamReaderTime = System.nanoTime() - startTime;
                System.out.println("File size: " + size + "MB");
                System.out.println("FileReader Time: " + fileReaderTime / 1000000.0 + "ms");
                System.out.println("InputStreamReader Time: " + inputStreamReaderTime / 1000000.0 + "ms");
                System.out.println();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void readWithFileReader(String filePath, int fileSizeInMB) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        char[] buffer = new char[fileSizeInMB * 1024 * 1024];
        while (fileReader.read(buffer) != -1) {}
        fileReader.close();
    }
    public static void readWithInputStreamReader(String filePath, int fileSizeInMB) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
        char[] buffer = new char[fileSizeInMB * 1024 * 1024];
        while (inputStreamReader.read(buffer) != -1) {}
        inputStreamReader.close();
    }
}
