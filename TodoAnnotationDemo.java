import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Todo {

    String task();

    String assignedTo();

    String priority() default "MEDIUM";
}

class ProjectTasks {

    @Todo(task = "Implement user authentication", assignedTo = "John", priority = "HIGH")
    public void userAuthentication() {
        System.out.println("User authentication logic.");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Jane")
    public void optimizeDatabase() {
        System.out.println("Database optimization logic.");
    }

    @Todo(task = "Refactor codebase", assignedTo = "Alice", priority = "LOW")
    public void refactorCode() {
        System.out.println("Code refactoring logic.");
    }
}

public class TodoAnnotationDemo {

    public static void main(String[] args) {
        Method[] methods = ProjectTasks.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName()
                        + ", Task: " + todo.task()
                        + ", Assigned To: " + todo.assignedTo()
                        + ", Priority: " + todo.priority());
            }
        }
    }
}
