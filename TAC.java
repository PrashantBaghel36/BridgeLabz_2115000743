import java.util.Scanner;

public class TAC {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the base of the triangle in cm: ");
        double baseCm = scanner.nextDouble();

        System.out.print("Enter the height of the triangle in cm: ");
        double heightCm = scanner.nextDouble();

        // Area of the triangle in square centimeters
        double areaCm2 = 0.5 * baseCm * heightCm;

        // Convert area to square inches (1 square inch = 6.4516 square cm)
        double areaIn2 = areaCm2 / 6.4516;

        // Output the results
        System.out.println("The area of the triangle is: ");
        System.out.println("In square centimeters: " + areaCm2 + " cm²");
        System.out.println("In square inches: " + areaIn2 + " in²");

    }
}

