import java.util.Scanner;

public class City {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter value for a: ");
        int a = scanner.nextInt();

        System.out.print("Enter value for b: ");
        int b = scanner.nextInt();

        System.out.print("Enter value for c: ");
        int c = scanner.nextInt();

        
        int result1 = a + (b * c);  // First operation: a + b * c
        int result2 = (a * b) + c;  // Second operation: a * b + c
        int result3 = c + (a / b);  // Third operation: c + a / b
        int result4 = (a % b) + c;  // Fourth operation: a % b + c

       
        System.out.println("The results of Int Operations are:");
        System.out.println("a + b * c = " + result1);
        System.out.println("a * b + c = " + result2);
        System.out.println("c + a / b = " + result3);
        System.out.println("a % b + c = " + result4);

        // Additional input for trip details
        scanner.nextLine();  // Consume the leftover newline

        // User inputs for trip information
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter departure city (fromCity): ");
        String fromCity = scanner.nextLine();

        System.out.print("Enter via city (viaCity): ");
        String viaCity = scanner.nextLine();

        System.out.print("Enter destination city (toCity): ");
        String toCity = scanner.nextLine();

        // Input distances
        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " in miles: ");
        double fromToVia = scanner.nextDouble();

        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " in miles: ");
        double viaToFinalCity = scanner.nextDouble();

        // Input time taken
        System.out.print("Enter time taken for the trip in hours: ");
        double timeTaken = scanner.nextDouble();

        // Calculate average speed (total distance / time)
        double totalDistance = fromToVia + viaToFinalCity;
        double averageSpeed = totalDistance / timeTaken;

        // Output trip details
        System.out.println("\nTrip Details for " + name + ":");
        System.out.println("From: " + fromCity);
        System.out.println("Via: " + viaCity);
        System.out.println("To: " + toCity);
        System.out.println("Total Distance: " + totalDistance + " miles");
        System.out.println("Time Taken: " + timeTaken + " hours");
        System.out.println("Average Speed: " + averageSpeed + " miles per hour");

        
       
    }
}
