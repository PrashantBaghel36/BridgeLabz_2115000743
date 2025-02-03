import java.util.*;
class Vehicle {
    private static double registrationFee = 100.0;
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }
    public void displayRegistrationDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Registration Number: " + this.registrationNumber);
            System.out.println("Owner Name: " + this.ownerName);
            System.out.println("Vehicle Type: " + this.vehicleType);
            System.out.println("Registration Fee: $" + registrationFee);
        }
    }
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter owner name: ");
        String ownerName = scanner.nextLine();
        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();
        System.out.print("Enter registration number: ");
        String registrationNumber = scanner.nextLine();
        Vehicle vehicle = new Vehicle(ownerName, vehicleType, registrationNumber);
        int choice;
        do {
            System.out.println("\nChoose an action:");
            System.out.println("1. Display registration details");
            System.out.println("2. Update registration fee");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    vehicle.displayRegistrationDetails();
                    break;
                case 2:
                    System.out.print("Enter new registration fee: ");
                    double newFee = scanner.nextDouble();
                    Vehicle.updateRegistrationFee(newFee);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }

}
