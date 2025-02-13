import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZeroSumSubarrays {

    // Function to find all subarrays with zero sum
    public static List<int[]> findZeroSumSubarrays(int[] nums) {
        // List to store the start and end indices of zero-sum subarrays
        List<int[]> result = new ArrayList<>();

        // HashMap to store cumulative sum and corresponding indices
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // Initialize sum to 0
        int sum = 0;

        // To handle the case when a subarray starts from index 0
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate cumulative sum
            sum += nums[i];

            // If the sum has been seen before, zero-sum subarray exists
            if (map.containsKey(sum)) {
                // Get all indices where this sum occurred before
                List<Integer> indices = map.get(sum);
                for (int start : indices) {
                    // Add the subarray's start and end indices to the result
                    result.add(new int[]{start + 1, i});
                }
            }

            // Add the current index to the list of indices for the current sum
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};

        List<int[]> result = findZeroSumSubarrays(nums);

        System.out.println("Zero Sum Subarrays:");
        for (int[] subarray : result) {
            System.out.print("Start: " + subarray[0] + ", End: " + subarray[1] + " -> Elements: [");
            for (int i = subarray[0]; i <= subarray[1]; i++) {
                System.out.print(nums[i] + (i < subarray[1] ? ", " : ""));
            }
            System.out.println("]");
        }
    }
}
