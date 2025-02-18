import java.util.*;
abstract class CourseType {
    String evaluationMethod;
    public CourseType(String evaluationMethod) {
        this.evaluationMethod = evaluationMethod;
    }
    public abstract void displayEvaluationDetails();
}
class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based");
    }
    @Override
    public void displayEvaluationDetails() {
        System.out.println("Evaluation Method: " + evaluationMethod + " - Final Exam");
    }
}
class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based");
    }
    @Override
    public void displayEvaluationDetails() {
        System.out.println("Evaluation Method: " + evaluationMethod + " - Assignments");
    }
}
class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based");
    }
    @Override
    public void displayEvaluationDetails() {
        System.out.println("Evaluation Method: " + evaluationMethod + " - Research Paper");
    }
}
class Course<T extends CourseType> {
    String courseName;
    T courseType;
    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }
    public void displayCourseDetails() {
        System.out.println("Course: " + courseName);
        courseType.displayEvaluationDetails();
    }
}
class University {
    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            course.displayEvaluationDetails();
        }
    }
    public static void main(String[] args) {
        Course<ExamCourse> examCourse = new Course<>("Mathematics", new ExamCourse());
        Course<AssignmentCourse> assignmentCourse = new Course<>("Computer Science", new AssignmentCourse());
        Course<ResearchCourse> researchCourse = new Course<>("Physics", new ResearchCourse());
        examCourse.displayCourseDetails();
        assignmentCourse.displayCourseDetails();
        researchCourse.displayCourseDetails();
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(new ExamCourse());
        allCourses.add(new AssignmentCourse());
        allCourses.add(new ResearchCourse());
        displayAllCourses(allCourses);
    }
}
