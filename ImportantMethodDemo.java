import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod {
    String level() default "HIGH";
}

class CriticalOperations {
    @ImportantMethod(level = "HIGH")
    public void performCriticalTask() {
        System.out.println("Performing critical task.");
    }

    @ImportantMethod(level = "MEDIUM")
    public void performSecondaryTask() {
        System.out.println("Performing secondary task.");
    }

    public void performRegularTask() {
        System.out.println("Performing regular task.");
    }
}

public class ImportantMethodDemo {
    public static void main(String[] args) {
        Method[] methods = CriticalOperations.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Importance Level: " + annotation.level());
            }
        }
    }
}