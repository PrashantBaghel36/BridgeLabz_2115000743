import java.util.Scanner;

public class DC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input distance in feet
        System.out.print("Enter the distance in feet: ");
        double distanceInFeet = scanner.nextDouble();

    
        double feetPerYard = 3;
        int yardsPerMile = 1760;

        // Convert distance to yards
        double distanceInYards = distanceInFeet / feetPerYard;

        // Convert distance to miles
        double distanceInMiles = distanceInYards / yardsPerMile;

        // Output the result
        System.out.println("The distance is:");
        System.out.println("In yards: " + distanceInYards + " yards");
        System.out.println("In miles: " + distanceInMiles + " miles");

  
    }
}

