import java.util.*;
class Patient {
    private static String hospitalName = "City General Hospital";
    private static int totalPatients = 0;
    private final int patientID;
    private String name;
    private int age;
    private String ailment;
    private static int nextPatientId = 1;
    public Patient(String name, int age, String ailment) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = nextPatientId++;
        totalPatients++;
    }
    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient ID: " + this.patientID);
            System.out.println("Name: " + this.name);
            System.out.println("Age: " + this.age);
            System.out.println("Ailment: " + this.ailment);
        }
    }
    public static int getTotalPatients() {
        return totalPatients;
    }

    public static void displayHospitalName() {
        System.out.println("Hospital Name: " + hospitalName);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patient age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter patient ailment: ");
        String ailment = scanner.nextLine();
        Patient patient = new Patient(name, age, ailment);
        int choice;
        do {
            System.out.println("\nChoose an action:");
            System.out.println("1. Display patient details");
            System.out.println("2. Display total patients");
            System.out.println("3. Display hospital name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    patient.displayPatientDetails();
                    break;
                case 2:
                    System.out.println("Total Patients: " + Patient.getTotalPatients());
                    break;
                case 3:
                    Patient.displayHospitalName();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
}
