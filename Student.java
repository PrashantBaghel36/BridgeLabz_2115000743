import java.util.*;
class Student {
    private static String universityName = "My University";
    private static int totalStudents = 0;
    private final int rollNumber;
    private String name;
    private char grade;
    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }
    public void displayStudentInfo() {
        if (this instanceof Student) {
            System.out.println("University: " + universityName);
            System.out.println("Roll Number: " + this.rollNumber);
            System.out.println("Name: " + this.name);
            System.out.println("Grade: " + this.grade);
        }
    }
    public void updateGrade(char newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
        }
    }
    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }
    public static void displayUniversityName() {
        System.out.println("University Name: " + universityName);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter grade: ");
        char grade = scanner.nextLine().charAt(0);
        Student student = new Student(name, rollNumber, grade);
        int choice;
        do {
            System.out.println("\nChoose an action:");
            System.out.println("1. Display student info");
            System.out.println("2. Update grade");
            System.out.println("3. Display total students");
            System.out.println("4. Display university name");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    student.displayStudentInfo();
                    break;
                case 2:
                    System.out.print("Enter new grade: ");
                    char newGrade = scanner.nextLine().charAt(0);
                    student.updateGrade(newGrade);
                    break;
                case 3:
                    Student.displayTotalStudents();
                    break;
                case 4:
                    Student.displayUniversityName();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }
}
