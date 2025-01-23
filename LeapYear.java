import java.util.Scanner;

public class LeapYear {

    public static void checkLeapYear(int year) {
        // Check if the year is greater than or equal to 1582
        if (year < 1582) {
            System.out.println("Year should be greater than or equal to 1582.");
            return;
        }

        // Check for Leap Year using multiple if-else statements
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println(year + " is a Leap Year.");
                } else {
                    System.out.println(year + " is not a Leap Year.");
                }
            } else {
                System.out.println(year + " is a Leap Year.");
            }
        } else {
            System.out.println(year + " is not a Leap Year.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
       
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
        checkLeapYear(year);
    }
}

