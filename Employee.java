import java.util.*;
class Employee {
    private static String companyName = "Acme Corp";
    private static int totalEmployees = 0;
    private final int id;
    private String name;
    private String designation;
    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }
    public void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("Company: " + companyName);
            System.out.println("ID: " + this.id);
            System.out.println("Name: " + this.name);
            System.out.println("Designation: " + this.designation);
        }
    }
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
    public static void displayCompanyName() {
        System.out.println("Company Name: " + companyName);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter employee designation: ");
        String designation = scanner.nextLine();
        Employee employee = new Employee(name, id, designation);
        int choice;
        do {
            System.out.println("\nChoose an action:");
            System.out.println("1. Display employee details");
            System.out.println("2. Display total employees");
            System.out.println("3. Display company name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    employee.displayEmployeeDetails();
                    break;
                case 2:
                    Employee.displayTotalEmployees();
                    break;
                case 3:
                    Employee.displayCompanyName();
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
