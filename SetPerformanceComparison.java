// Performance Comparison: Compare the performance of HashSet,
// LinkedHashSet, and TreeSet in terms of adding, removing, and searching for
// policies.



import java.util.*;

public class SetPerformanceComparison {
    public static void main(String[] args) {
        int elementCount = 1_000_000;
        Random random = new Random();
        List<Integer> testData = new ArrayList<>();
        
        for (int i = 0; i < elementCount; i++) {
            testData.add(random.nextInt());
        }

        comparePerformance("HashSet", new HashSet<>(), testData);
        comparePerformance("LinkedHashSet", new LinkedHashSet<>(), testData);
        comparePerformance("TreeSet", new TreeSet<>(), testData);
    }

    private static void comparePerformance(String setType, Set<Integer> set, List<Integer> testData) {
        long startTime, endTime;

        startTime = System.nanoTime();
        for (int num : testData) {
            set.add(num);
        }
        endTime = System.nanoTime();
        System.out.println(setType + " - Add Time: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            set.contains(testData.get(i));
        }
        endTime = System.nanoTime();
        System.out.println(setType + " - Search Time: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            set.remove(testData.get(i));
        }
        endTime = System.nanoTime();
        System.out.println(setType + " - Remove Time: " + (endTime - startTime) / 1_000_000 + " ms");

        System.out.println("--------------------------------");
    }
}
