import java.util.*;
abstract class JobRole {
    String roleName;
    public JobRole(String roleName) {
        this.roleName = roleName;
    }
    public abstract void displayJobDetails();
}
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
    @Override
    public void displayJobDetails() {
        System.out.println("Role: " + roleName + " - Focus on software development and coding.");
    }
}
class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
    @Override
    public void displayJobDetails() {
        System.out.println("Role: " + roleName + " - Focus on analyzing and interpreting complex data.");
    }
}
class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
    @Override
    public void displayJobDetails() {
        System.out.println("Role: " + roleName + " - Focus on product development and strategy.");
    }
}
class Resume<T extends JobRole> {
    String applicantName;
    T jobRole;
    public Resume(String applicantName, T jobRole) {
        this.applicantName = applicantName;
        this.jobRole = jobRole;
    }
    public void displayResume() {
        System.out.println("Applicant: " + applicantName);
        jobRole.displayJobDetails();
    }
}
class ResumeScreeningSystem {
    public static void screenResumes(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            resume.displayJobDetails();
        }
    }
    public static void main(String[] args) {
        Resume<SoftwareEngineer> softwareEngineerResume = new Resume<>("Amit", new SoftwareEngineer());
        Resume<DataScientist> dataScientistResume = new Resume<>("Nitin", new DataScientist());
        Resume<ProductManager> productManagerResume = new Resume<>("Charul", new ProductManager());
        softwareEngineerResume.displayResume();
        dataScientistResume.displayResume();
        productManagerResume.displayResume();
        List<JobRole> allResumes = new ArrayList<>();
        allResumes.add(new SoftwareEngineer());
        allResumes.add(new DataScientist());
        allResumes.add(new ProductManager());
        screenResumes(allResumes);
    }
}
