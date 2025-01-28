import java.util.*;
public class NumberChecker4 {
    public static void main(String[] args) {
        int number = 121; // Example number
        int digitCount = countDigits(number);
        int[] digits = storeDigits(number, digitCount);
        int[] reversedDigits = reverseDigits(digits);
        System.out.println("Original Digits: " + Arrays.toString(digits));
        System.out.println("Reversed Digits: " + Arrays.toString(reversedDigits));
        if (isPalindrome(digits, reversedDigits)) {
            System.out.println("It's a Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
        if (isDuckNumber(digits)) {
            System.out.println("It's a Duck Number");
        } else {
            System.out.println("Not a Duck Number");
        }
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
    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }
    public static boolean isPalindrome(int[] digits, int[] reversedDigits) {
        return Arrays.equals(digits, reversedDigits);
    }
    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }
}
