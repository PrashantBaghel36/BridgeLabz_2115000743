import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {}

class PerformanceTester {
    @LogExecutionTime
    public void fastMethod() {
        for (int i = 0; i < 1000; i++) {
        }
    }

    @LogExecutionTime
    public void slowMethod() {
        for (int i = 0; i < 1000000; i++) {
        }
    }
}

public class ExecutionTimeLogger {
    public static void main(String[] args) throws Exception {
        PerformanceTester tester = new PerformanceTester();
        Method[] methods = PerformanceTester.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(tester);
                long endTime = System.nanoTime();
                System.out.println("Execution time of " + method.getName() + ": " + (endTime - startTime) + " nanoseconds");
            }
        }
    }
}