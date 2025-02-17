import java.util.Random;
import java.util.Arrays;
public class SortingComparison {
    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};
        Random rand = new Random();
        for (int size : datasetSizes) {
            int[] dataset = new int[size];
            for (int i = 0; i < size; i++) {
                dataset[i] = rand.nextInt(size);
            }
            int[] bubbleSortDataset = Arrays.copyOf(dataset, dataset.length);
            int[] mergeSortDataset = Arrays.copyOf(dataset, dataset.length);
            int[] quickSortDataset = Arrays.copyOf(dataset, dataset.length);
            long startTime = System.nanoTime();
            bubbleSort(bubbleSortDataset);
            long bubbleSortTime = System.nanoTime() - startTime;
            startTime = System.nanoTime();
            mergeSort(mergeSortDataset, 0, mergeSortDataset.length - 1);
            long mergeSortTime = System.nanoTime() - startTime;
            startTime = System.nanoTime();
            quickSort(quickSortDataset, 0, quickSortDataset.length - 1);
            long quickSortTime = System.nanoTime() - startTime;
            System.out.println("Dataset size: " + size);
            System.out.println("Bubble Sort Time: " + bubbleSortTime / 1000000.0 + "ms");
            System.out.println("Merge Sort Time: " + mergeSortTime / 1000000.0 + "ms");
            System.out.println("Quick Sort Time: " + quickSortTime / 1000000.0 + "ms");
            System.out.println();
        }
    }
    public static void bubbleSort(int[] dataset) {
        int n = dataset.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (dataset[j] > dataset[j + 1]) {
                    int temp = dataset[j];
                    dataset[j] = dataset[j + 1];
                    dataset[j + 1] = temp;
                }
            }
        }
    }
    public static void mergeSort(int[] dataset, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(dataset, left, mid);
            mergeSort(dataset, mid + 1, right);
            merge(dataset, left, mid, right);
        }
    }
    public static void merge(int[] dataset, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        System.arraycopy(dataset, left, leftArray, 0, n1);
        System.arraycopy(dataset, mid + 1, rightArray, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                dataset[k] = leftArray[i];
                i++;
            } else {
                dataset[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            dataset[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            dataset[k] = rightArray[j];
            j++;
            k++;
        }
    }
    public static void quickSort(int[] dataset, int low, int high) {
        if (low < high) {
            int pivot = partition(dataset, low, high);
            quickSort(dataset, low, pivot - 1);
            quickSort(dataset, pivot + 1, high);
        }
    }
    public static int partition(int[] dataset, int low, int high) {
        int pivot = dataset[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (dataset[j] <= pivot) {
                i++;
                int temp = dataset[i];
                dataset[i] = dataset[j];
                dataset[j] = temp;
            }
        }
        int temp = dataset[i + 1];
        dataset[i + 1] = dataset[high];
        dataset[high] = temp;
        return i + 1;
    }
}
