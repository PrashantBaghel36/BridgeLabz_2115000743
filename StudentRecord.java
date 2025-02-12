import java.util.*;

class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;

    Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentList {
    Student head;

    public StudentList() {
        head = null;
    }

    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    public void addAtPosition(int position, int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (position == 1) {
            newStudent.next = head;
            head = newStudent;
            return;
        }
        Student temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    public void deleteByRollNumber(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found");
            return;
        }
        temp.next = temp.next.next;
    }

    public void searchByRollNumber(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Student Found: " + temp.name + ", " + temp.age + ", " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found");
    }

    public void displayAllStudents() {
        if (head == null) {
            System.out.println("No students in the list");
            return;
        }
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public void updateGrade(int rollNumber, String newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Updated Grade for " + temp.name + " to " + newGrade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found");
    }
}

public class StudentRecord {
    public static void main(String[] args) {
        StudentList list = new StudentList();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nStudent Record Management System");
            System.out.println("1. Add student at beginning");
            System.out.println("2. Add student at end");
            System.out.println("3. Add student at position");
            System.out.println("4. Delete student by roll number");
            System.out.println("5. Search student by roll number");
            System.out.println("6. Display all students");
            System.out.println("7. Update student grade");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter roll number: ");
                    int roll1 = scanner.nextInt();
                    System.out.print("Enter name: ");
                    String name1 = scanner.next();
                    System.out.print("Enter age: ");
                    int age1 = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    String grade1 = scanner.next();
                    list.addAtBeginning(roll1, name1, age1, grade1);
                    break;
                case 2:
                    System.out.print("Enter roll number: ");
                    int roll2 = scanner.nextInt();
                    System.out.print("Enter name: ");
                    String name2 = scanner.next();
                    System.out.print("Enter age: ");
                    int age2 = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    String grade2 = scanner.next();
                    list.addAtEnd(roll2, name2, age2, grade2);
                    break;
                case 3:
                    System.out.print("Enter position: ");
                    int pos = scanner.nextInt();
                    System.out.print("Enter roll number: ");
                    int roll3 = scanner.nextInt();
                    System.out.print("Enter name: ");
                    String name3 = scanner.next();
                    System.out.print("Enter age: ");
                    int age3 = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    String grade3 = scanner.next();
                    list.addAtPosition(pos, roll3, name3, age3, grade3);
                    break;
                case 4:
                    System.out.print("Enter roll number to delete: ");
                    int rollToDelete = scanner.nextInt();
                    list.deleteByRollNumber(rollToDelete);
                    break;
                case 5:
                    System.out.print("Enter roll number to search: ");
                    int rollToSearch = scanner.nextInt();
                    list.searchByRollNumber(rollToSearch);
                    break;
                case 6:
                    list.displayAllStudents();
                    break;
                case 7:
                    System.out.print("Enter roll number to update grade: ");
                    int rollToUpdate = scanner.nextInt();
                    System.out.print("Enter new grade: ");
                    String newGrade = scanner.next();
                    list.updateGrade(rollToUpdate, newGrade);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);
    }
}
