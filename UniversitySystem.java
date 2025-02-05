// Faculty Class (Aggregation: Can Exist Without Department)
class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Department Class (Composition: Exists Only Inside University)
class Department {
    private String deptName;

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }
}

// University Class (Owns Departments in Composition)
class University {
    private String universityName;
    private Department dept1, dept2; // University contains Departments (Composition)

    public University(String universityName, String dept1Name, String dept2Name) {
        this.universityName = universityName;
        this.dept1 = new Department(dept1Name);
        this.dept2 = new Department(dept2Name);
    }

    public void showUniversityDetails() {
        System.out.println("University: " + universityName);
        System.out.println("  Department: " + dept1.getDeptName());
        System.out.println("  Department: " + dept2.getDeptName());
    }

    // Simulating Deletion of University (Deletes Departments)
    public void shutdown() {
        System.out.println("Shutting down " + universityName + "... All departments are deleted.");
        this.dept1 = null;
        this.dept2 = null;
    }
}

// Main Class
public class UniversitySystem {
    public static void main(String[] args) {
        // Create University
        University uni = new University("Harvard University", "Computer Science", "Physics");

        // Create Faculty Members (Can Exist Independently)
        Faculty profAlice = new Faculty("Dr. Alice");
        Faculty profBob = new Faculty("Dr. Bob");

        // Display University and Departments
        uni.showUniversityDetails();

        // Show that Faculty Exists Independently
        System.out.println("Faculty Members:");
        System.out.println("  - " + profAlice.getName());
        System.out.println("  - " + profBob.getName());

        // Delete University (Composition: Departments Also Get Deleted)
        uni.shutdown();
    }
}

