// Develop an Employee class with:
// employeeID (public).
// department (protected).
// salary (private).
// Write methods to:
// Modify salary using a public method.
// Create a subclass Manager to access employeeID and department.


class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void modifySalary(double salary) {
        this.salary = salary;
    }
}

class Manager extends Employee {
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void displayManagerDetails() {
        System.out.println("Manager Employee ID: " + employeeID);
        System.out.println("Department: " + department);
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        Employee employee = new Employee(101, "Marketing", 45000.0);
        System.out.println("Salary: " + employee.getSalary());
        employee.modifySalary(50000.0);
        System.out.println("Updated Salary: " + employee.getSalary());

        Manager manager = new Manager(201, "Sales", 70000.0);
        manager.displayManagerDetails();
    }
}
