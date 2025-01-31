import java.util.*;
public class Employee {
    private String name;
    private int id;
    private double salary;
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: $" + salary); // Added $ for currency
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter details for employee 1:");
        System.out.print("Name: ");
        String name1 = scanner.nextLine();
        System.out.print("ID: ");
        int id1 = scanner.nextInt();
        System.out.print("Salary: ");
        double salary1 = scanner.nextDouble();
        scanner.nextLine();
        Employee employee1 = new Employee(name1, id1, salary1);
        System.out.println("\nEnter details for employee 2:");
        System.out.print("Name: ");
        String name2 = scanner.nextLine();
        System.out.print("ID: ");
        int id2 = scanner.nextInt();
        System.out.print("Salary: ");
        double salary2 = scanner.nextDouble();
        scanner.nextLine(); 
        Employee employee2 = new Employee(name2, id2, salary2);
        employee1.displayDetails();
        System.out.println("------------------");
        employee2.displayDetails();
    }
}
