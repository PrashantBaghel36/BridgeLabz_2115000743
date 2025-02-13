import java.util.HashMap;

public class CountPairWithGivenSum {

    // Method to check for a pair with given sum
    public static void checkPairWithSum(int[] nums, int target) {
        // HashMap to store numbers and their indices
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            int requiredNumber = target - currentNumber;

            // Check if the required number is already in the map
            if (map.containsKey(requiredNumber)) {
                System.out.println("Pair Found: (" + requiredNumber + ", " + currentNumber + ")");
                return;
            }

            // Store the current number in the map
            map.put(currentNumber, i);
        }

        // If no pair is found
        System.out.println("No Pair Found with Sum " + target);
    }

    // Main method to test the solution
    public static void main(String[] args) {
        int[] nums = {10, 2, 8, 5, 7, 3};
        int target = 15;

        checkPairWithSum(nums, target);
    }
}
