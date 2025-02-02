// Design a Course class with:
// Instance Variables: courseName, duration, fee.
// Class Variable: instituteName (common for all courses).
// Methods:
// An instance method displayCourseDetails() to display the course details.
// A class method updateInstituteName() to modify the institute name for all courses.

class Course{
    String courseName;
    int duration;
    double fee;
    public static String instituteName = "GLA Unversity";
    Course(String courseName, int duration, double fee){
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }
    public void displayCourseDetails(){
        System.out.println("Course name: "+courseName);
        System.out.println("Duration: "+duration);
        System.out.println("Fee: "+fee);
        System.err.println("Institue Name: "+instituteName);
    }
    static void updateInstituteName(String instituteName){
        Course.instituteName = instituteName;
    } 
}
public class OnlineCourseManagement {
    public static void main(String[] args) {
        Course course1 = new Course("B.Tech", 4, 1000000);
        Course course2 = new Course("BCA", 3, 500000);
        Course course3 = new Course("MBA", 2, 400000);
        System.out.println("------------------Course 1 details-------------");
        course1.displayCourseDetails();
        System.out.println("------------------Course 2 details-------------");
        course2.displayCourseDetails();
        System.out.println("------------------Course 3 details-------------");
        course3.displayCourseDetails();
        System.out.println("\n--------------Institute Name updated------------\n");
        Course.updateInstituteName("CAPGEMINI");
        course1.displayCourseDetails();
    }
}
