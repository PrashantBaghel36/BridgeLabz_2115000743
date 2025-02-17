import java.util.*;
public class DataStructureSearchComparison {
    public static void main(String[] args) {
        int[] datasetSizes = {1000, 100000, 1000000};
        for (int size : datasetSizes) {
            List<Integer> dataset = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                dataset.add(i);
            }
            long startTime = System.nanoTime();
            arraySearch(dataset, size);
            long arraySearchTime = System.nanoTime() - startTime;
            HashSet<Integer> hashSet = new HashSet<>(dataset);
            startTime = System.nanoTime();
            hashSetSearch(hashSet, size);
            long hashSetSearchTime = System.nanoTime() - startTime;
            TreeSet<Integer> treeSet = new TreeSet<>(dataset);
            startTime = System.nanoTime();
            treeSetSearch(treeSet, size);
            long treeSetSearchTime = System.nanoTime() - startTime;
            System.out.println("Dataset size: " + size);
            System.out.println("Array Search Time: " + arraySearchTime / 1000000.0 + "ms");
            System.out.println("HashSet Search Time: " + hashSetSearchTime / 1000000.0 + "ms");
            System.out.println("TreeSet Search Time: " + treeSetSearchTime / 1000000.0 + "ms");
            System.out.println();
        }
    }
    public static void arraySearch(List<Integer> dataset, int size) {
        for (int i = 0; i < size; i++) {
            if (dataset.get(i) == size - 1) break;
        }
    }
    public static void hashSetSearch(HashSet<Integer> hashSet, int size) {
        hashSet.contains(size - 1);
    }
    public static void treeSetSearch(TreeSet<Integer> treeSet, int size) {
        treeSet.contains(size - 1);
    }
}
