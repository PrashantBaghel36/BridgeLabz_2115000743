class Person {
    String name;
    int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void displayPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
class Teacher extends Person {
    String subject;
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    public void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}
class Student extends Person {
    int grade;
    public Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }
    public void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}
class Staff extends Person {
    String department;
    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }
    public void displayRole() {
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}
public class SchoolSystem {
    public static void main(String[] args) {
        Teacher mathTeacher = new Teacher("Mr. Smith", 35, "Mathematics");
        Student student = new Student("Alice", 16, 10);
        Staff librarian = new Staff("Ms. Johnson", 40, "Library");
        mathTeacher.displayPersonInfo();
        mathTeacher.displayRole();
        System.out.println();
        student.displayPersonInfo();
        student.displayRole();
        System.out.println();
        librarian.displayPersonInfo();
        librarian.displayRole();
    }
}
