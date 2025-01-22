public class DistanceConverter {
    public static void main(String[] args) {
        // Conversion factor
        double kmToMiles = 1.6;

        // Given distance in kilometers
        double km = 10.8;

        // Convert kilometers to miles
        double miles = km * kmToMiles;

        // Output the result
        System.out.println("The distance " + km + " km in miles is " + miles + " miles.");
    }
}

