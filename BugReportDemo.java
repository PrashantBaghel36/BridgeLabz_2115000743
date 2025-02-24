import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

class SoftwareComponent {
    @BugReport(description = "Null pointer exception on line 42")
    @BugReport(description = "Array index out of bounds on line 56")
    public void process() {
        System.out.println("Processing...");
    }
}

public class BugReportDemo {
    public static void main(String[] args) {
        try {
            Method method = SoftwareComponent.class.getMethod("process");
            BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);

            for (BugReport bugReport : bugReports) {
                System.out.println("Bug Description: " + bugReport.description());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}