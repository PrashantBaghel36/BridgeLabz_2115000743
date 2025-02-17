import java.util.Arrays;
import java.util.Random;
public class SearchComparison {
    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};
        Random rand = new Random();
        for (int size : datasetSizes) {
            int[] dataset = new int[size];
            for (int i = 0; i < size; i++) {
                dataset[i] = rand.nextInt(size);
            }
            int target = rand.nextInt(size);
            long startTime = System.nanoTime();
            linearSearch(dataset, target);
            long linearSearchTime = System.nanoTime() - startTime;
            Arrays.sort(dataset);
            startTime = System.nanoTime();
            binarySearch(dataset, target);
            long binarySearchTime = System.nanoTime() - startTime;
            System.out.println("Dataset size: " + size);
            System.out.println("Linear Search Time: " + linearSearchTime / 1000000.0 + "ms");
            System.out.println("Binary Search Time: " + binarySearchTime / 1000000.0 + "ms");
            System.out.println();
        }
    }

    public static int linearSearch(int[] dataset, int target) {
        for (int i = 0; i < dataset.length; i++) {
            if (dataset[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] dataset, int target) {
        int left = 0, right = dataset.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dataset[mid] == target) {
                return mid;
            }
            if (dataset[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
