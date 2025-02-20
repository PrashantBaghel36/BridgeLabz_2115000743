// Generate Binary Numbers Using a Queue
// Generate the first N binary numbers (as strings) using a queue.
// Example:
// N=5 → Output: ["1", "10", "11", "100", "101"].


import java.util.*;

public class BinaryNumbersQueue {
    public static void main(String[] args) {
        int N = 5;
        List<String> result = generateBinaryNumbers(N);
        System.out.println(result);
    }

    private static List<String> generateBinaryNumbers(int N) {
        List<String> binaryNumbers = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i = 0; i < N; i++) {
            String current = queue.poll();
            binaryNumbers.add(current);
            queue.add(current + "0");
            queue.add(current + "1");
        }
        
        return binaryNumbers;
    }
}
