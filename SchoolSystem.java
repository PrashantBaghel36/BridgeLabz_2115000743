// Course Class (Many-to-Many Relationship with Student)
class Course {
    private String courseName;
    private Student student1, student2; // Allow only two students for simplicity

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void enrollStudent(Student student) {
        if (student1 == null) {
            student1 = student;
        } else if (student2 == null) {
            student2 = student;
        } else {
            System.out.println("Course " + courseName + " is full!");
        }
    }

    public void showEnrolledStudents() {
        System.out.println("Course: " + courseName + " | Enrolled Students:");
        if (student1 != null) System.out.println("  - " + student1.getName());
        if (student2 != null) System.out.println("  - " + student2.getName());
    }
}

// Student Class (Can Enroll in Multiple Courses)
class Student {
    private String name;
    private Course course1, course2; // Allow only two courses for simplicity

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void enrollInCourse(Course course) {
        if (course1 == null) {
            course1 = course;
            course.enrollStudent(this);
        } else if (course2 == null) {
            course2 = course;
            course.enrollStudent(this);
        } else {
            System.out.println(name + " cannot enroll in more courses!");
        }
    }

    public void showEnrolledCourses() {
        System.out.println(name + " is enrolled in:");
        if (course1 != null) System.out.println("  - " + course1.getCourseName());
        if (course2 != null) System.out.println("  - " + course2.getCourseName());
    }
}

// School Class (Aggregation: Contains Students)
class School {
    private String schoolName;
    private Student student1, student2; // Allow only two students for simplicity

    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    public void addStudent(Student student) {
        if (student1 == null) {
            student1 = student;
        } else if (student2 == null) {
            student2 = student;
        } else {
            System.out.println("School " + schoolName + " is full!");
        }
    }

    public void showAllStudents() {
        System.out.println("School: " + schoolName + " | Students:");
        if (student1 != null) System.out.println("  - " + student1.getName());
        if (student2 != null) System.out.println("  - " + student2.getName());
    }
}

// Main Class
public class SchoolSystem {
    public static void main(String[] args) {
        // Create School
        School school = new School("Greenwood High");

        // Create Students
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        // Create Courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        // Enroll Students in Courses
        alice.enrollInCourse(math);
        alice.enrollInCourse(science);
        bob.enrollInCourse(math);

        // Add Students to School
        school.addStudent(alice);
        school.addStudent(bob);

        // Display Data
        school.showAllStudents();
        alice.showEnrolledCourses();
        bob.showEnrolledCourses();
        math.showEnrolledStudents();
        science.showEnrolledStudents();
    }
}

   
