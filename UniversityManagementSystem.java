public class UniversityManagementSystem {

    // Student Class
    public static class Student {
        private int studentId;
        private String name;
        private Course[] enrolledCourses;
        private int courseCount;

        public Student(int studentId, String name) {
            this.studentId = studentId;
            this.name = name;
            this.enrolledCourses = new Course[5];  // Max of 5 courses for simplicity
            this.courseCount = 0;
        }

        public void enrollCourse(Course course) {
            if (courseCount < enrolledCourses.length) {
                enrolledCourses[courseCount] = course;
                courseCount++;
                course.addStudent(this);  // Add this student to the course
            } else {
                System.out.println("Student cannot enroll in more courses.");
            }
        }

        public int getStudentId() {
            return studentId;
        }

        public String getName() {
            return name;
        }

        public Course[] getEnrolledCourses() {
            return enrolledCourses;
        }
    }

    // Professor Class
    public static class Professor {
        private int professorId;
        private String name;
        private Course[] coursesTaught;
        private int courseCount;

        public Professor(int professorId, String name) {
            this.professorId = professorId;
            this.name = name;
            this.coursesTaught = new Course[3];  // Max of 3 courses
            this.courseCount = 0;
        }

        public void assignProfessor(Course course) {
            if (courseCount < coursesTaught.length) {
                coursesTaught[courseCount] = course;
                courseCount++;
                course.setProfessor(this);  // Assign this professor to the course
            } else {
                System.out.println("Professor cannot teach more courses.");
            }
        }

        public int getProfessorId() {
            return professorId;
        }

        public String getName() {
            return name;
        }

        public Course[] getCoursesTaught() {
            return coursesTaught;
        }
    }

    // Course Class
    public static class Course {
        private int courseId;
        private String name;
        private Professor professor;
        private Student[] enrolledStudents;
        private int studentCount;

        public Course(int courseId, String name) {
            this.courseId = courseId;
            this.name = name;
            this.enrolledStudents = new Student[30];  // Max of 30 students per course
            this.studentCount = 0;
        }

        public void addStudent(Student student) {
            if (studentCount < enrolledStudents.length) {
                enrolledStudents[studentCount] = student;
                studentCount++;
            } else {
                System.out.println("Course is full, cannot enroll more students.");
            }
        }

        public void setProfessor(Professor professor) {
            this.professor = professor;
        }

        public int getCourseId() {
            return courseId;
        }

        public String getName() {
            return name;
        }

        public Professor getProfessor() {
            return professor;
        }

        public Student[] getEnrolledStudents() {
            return enrolledStudents;
        }
    }

    public static void main(String[] args) {
        // Create Professors
        Professor professor1 = new Professor(1, "Dr. Alice");
        Professor professor2 = new Professor(2, "Dr. Bob");

        // Create Courses
        Course course1 = new Course(101, "Computer Science");
        Course course2 = new Course(102, "Mathematics");

        // Assign professors to courses
        professor1.assignProfessor(course1);
        professor2.assignProfessor(course2);

        // Create Students
        Student student1 = new Student(1, "John");
        Student student2 = new Student(2, "Jane");

        // Students enroll in courses
        student1.enrollCourse(course1);
        student1.enrollCourse(course2);

        student2.enrollCourse(course2);

        // Print course details
        System.out.println(course1.getName() + " is taught by " + course1.getProfessor().getName());
        System.out.println("Students enrolled: ");
        for (Student student : course1.getEnrolledStudents()) {
            if (student != null) {
                System.out.println("- " + student.getName());
            }
        }

        System.out.println();

        System.out.println(course2.getName() + " is taught by " + course2.getProfessor().getName());
        System.out.println("Students enrolled: ");
        for (Student student : course2.getEnrolledStudents()) {
            if (student != null) {
                System.out.println("- " + student.getName());
            }
        }
    }
}

