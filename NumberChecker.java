import java.util.*;
public class NumberChecker {
    public static void main(String[] args) {
        int number = 153;
        int digitCount = countDigits(number);
        System.out.println("Digit Count: " + digitCount);
        int[] digits = storeDigits(number, digitCount);
        System.out.println("Digits: " + Arrays.toString(digits));
        if (isDuckNumber(digits)) {
            System.out.println("It's a Duck Number");
        } else {
            System.out.println("Not a Duck Number");
        }
        if (isArmstrongNumber(number, digits, digitCount)) {
            System.out.println("It's an Armstrong Number");
        } else {
            System.out.println("Not an Armstrong Number");
        }
        int[] largest = findLargestTwo(digits);
        System.out.println("Largest: " + largest[0] + ", Second Largest: " + largest[1]);
        int[] smallest = findSmallestTwo(digits);
        System.out.println("Smallest: " + smallest[0] + ", Second Smallest: " + smallest[1]);
    }
    public static int countDigits(int number) {
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }
    public static int[] storeDigits(int number, int digitCount) {
        int[] digits = new int[digitCount];
        for (int i = digitCount - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }
    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }
    public static boolean isArmstrongNumber(int number, int[] digits, int digitCount) {
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, digitCount);
        }
        return sum == number;
    }
    public static int[] findLargestTwo(int[] array) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        return new int[]{largest, secondLargest};
    }
    public static int[] findSmallestTwo(int[] array) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : array) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest && num != smallest) {
                secondSmallest = num;
            }
        }
        return new int[]{smallest, secondSmallest};
    }
}
