import java.util.HashSet;

public class LongestConsecutiveSequence {

    // Method to find the length of the longest consecutive sequence
    public static int longestConsecutive(int[] nums) {
        // Edge case: if array is empty, return 0
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Store all elements in a HashSet
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Initialize max length
        int maxLength = 0;

        // Check for the start of a sequence
        for (int num : nums) {
            // Check if num is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                // Update max length
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        int result = longestConsecutive(nums);

        System.out.println("Longest Consecutive Sequence Length: " + result);
    }
}
